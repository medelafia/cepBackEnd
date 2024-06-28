package com.med.accountservice.usersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.imagesManagement.service.ImageService;
import com.med.accountservice.offersManagement.entity.Room;
import com.med.accountservice.offersManagement.repository.RoomRepo;
import com.med.accountservice.usersManagement.dto.HotelPosition;
import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.dto.RoomRequest;
import com.med.accountservice.usersManagement.entity.Hotel;
import com.med.accountservice.usersManagement.mapper.ProviderMapper;
import com.med.accountservice.usersManagement.repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {
    @Autowired
    private HotelRepo hotelRepo ;
    @Autowired
    private RoomRepo roomRepo ;
    @Autowired
    private ImageService imageService ;
    public List<Room> addNewRoom(int providerId , RoomRequest roomRequest)  {
        if(hotelRepo.findById(providerId).isPresent()) {
            Hotel hotel = hotelRepo.findById(providerId).get() ;
            Room room = Room.builder()
                    .adults(roomRequest.getAdults())
                    .available(roomRequest.isAvailable())
                    .nbOfRooms(roomRequest.getNbOfRooms())
                    .airConditioning(roomRequest.isAirConditioning())
                    .freeWifi(roomRequest.isFreeWifi())
                    .hasTv(roomRequest.isHasTv())
                    .kingBeds(roomRequest.getKingBeds())
                    .twinsBeds(roomRequest.getTwinsBeds())
                    .roomNumber(roomRequest.getRoomNumber())
                    .childs(roomRequest.getChilds())
                    .roomType(roomRequest.getRoomType())
                    .build() ;
            List<Image> images = imageService.uploadImages( roomRequest.getMultipartFile() );
            room.setImages(images);
            hotel.createNewRoom(roomRepo.save(room)) ;
            hotelRepo.save(hotel);
            return hotel.getRooms() ;
        }else {
            throw new NoElementException("the hotel not found ") ;
        }
    }
    public List<Room> getAllRoomsByHotelId(int id){
        Hotel hotel = hotelRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("the hotel not exist") ;
        }) ;
        if(hotel != null) {
            return hotel.getRooms() ;
        }
        return null ;
    }

    public List<HotelPosition> getAllHotelsPositions() {
        List<Hotel> hotels = hotelRepo.findAll() ;
        List<HotelPosition> hotelPositions = hotels.stream().map(hotel -> {
            return HotelPosition.builder()
                    .hotelId(hotel.getId())
                    .lat(hotel.getLatitude())
                    .lng(hotel.getLongitude())
                    .build() ;
        }).collect(Collectors.toList());
        return hotelPositions ;
    }
    public List<ProviderResponse> getAllHotels() {
        return hotelRepo.findAll().stream().map(hotel -> {
            return ProviderMapper.toProviderResponse(hotel) ;
        }).collect(Collectors.toList());
    }

    public void deleteRoom(int id, int roomId) {
        if(hotelRepo.findById(id).isPresent()) {
            Hotel hotel = hotelRepo.findById(id).get() ;
            if(roomRepo.findById(roomId).isPresent()) {
                Room room = roomRepo.findById(roomId).get() ;
                if(hotel.getRooms().contains(room)){
                    hotel.setRooms(hotel.getRooms().stream().filter(r -> r.getId() != roomId).toList()) ;
                    hotelRepo.save(hotel) ;
                    roomRepo.deleteById(roomId);
                }else {
                    throw new NoElementException("your hotel not contains this room") ;
                }
            }else {
                throw new NoElementException("the room not found") ;
            }
        }else {
            throw new NoElementException("the hotel not found") ;
        }
    }

    public List<ProviderResponse> getAllHotelsContainsKeyword(String keyword) {
        return hotelRepo.findAllByNameContains(keyword).stream().map(hotel -> ProviderMapper.toProviderResponse(hotel)).collect(Collectors.toList());
    }

    public List<ProviderResponse> getNearbyHotels(float lng, float lat) {
        RestClient restClient = RestClient.create() ;
        HashMap<String , ArrayList> map = restClient.get()
                .uri("http://localhost:8000/getNearbyHotels?lng="+lng+"&lat="+lat)
                .retrieve()
                .body(HashMap.class) ;
        List<ProviderResponse> providerResponses = (List<ProviderResponse>) map.get("indices").stream().map(id -> {
            return ProviderMapper.toProviderResponse(hotelRepo.findById((Integer)id).get()) ;
        }).collect(Collectors.toList());
        return providerResponses  ;
    }
}
