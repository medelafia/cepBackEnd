package com.med.accountservice.usersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.imagesManagement.service.ImageService;
import com.med.accountservice.offersManagement.entity.Room;
import com.med.accountservice.offersManagement.repository.RoomRepo;
import com.med.accountservice.usersManagement.dto.HotelPosition;
import com.med.accountservice.usersManagement.dto.HotelResponse;
import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.dto.RoomRequest;
import com.med.accountservice.usersManagement.entity.Amenitie;
import com.med.accountservice.usersManagement.entity.Hotel;
import com.med.accountservice.usersManagement.mapper.ProviderMapper;
import com.med.accountservice.usersManagement.repository.AmenitieRepo;
import com.med.accountservice.usersManagement.repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private AmenitieRepo amenitieRepo ;
    public Hotel getAuthenticated() {
        return hotelRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get() ;
    }
    @Transactional
    public List<Room> addNewRoom(MultipartFile multipartFile , Room room)  {
            Hotel hotel = this.getAuthenticated() ;
            Image image = imageService.updloadImage(multipartFile) ;
            room.setImage(image);
            room.setHotel(hotel);
            hotel.createNewRoom(roomRepo.save(room)) ;
            hotelRepo.save(hotel);
            return hotel.getRooms() ;
    }
    public List<Room> getAllRooms(){
        List<Room> rooms = this.getAuthenticated().getRooms() ;
        rooms.forEach(room-> {
            room.setProvider(ProviderMapper.toProviderResponse(room.getHotel())) ;
        });
        return rooms ;
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
    @Transactional
    public Room updateRoom(Room newRoom) {
        Room room = roomRepo.findById(newRoom.getId()).get() ;
        room.setAvailable(newRoom.isAvailable()) ;
        room.setAdults(newRoom.getAdults());
        room.setChilds(newRoom.getChilds());
        room.setHasTv(newRoom.isHasTv());
        room.setAirConditioning(newRoom.isAirConditioning());
        room.setRoomType(newRoom.getRoomType());
        room.setFreeWifi(newRoom.isFreeWifi());
        room.setTwinsBeds(newRoom.getTwinsBeds());
        room.setPrice(newRoom.getPrice());
        return roomRepo.save(room) ;
    }
    @Transactional

    public void deleteRoom(int roomId) {
            Hotel hotel = this.getAuthenticated() ;
            if(roomRepo.findById(roomId).isPresent()) {
                Room room = roomRepo.findById(roomId).get() ;
                if(hotel.getRooms().contains(room)){
                    roomRepo.deleteById(roomId);
                }else {
                    throw new NoElementException("your hotel not contains this room") ;
                }
            }else {
                throw new NoElementException("the room not found") ;
            }
    }

    public List<HotelResponse> getAllHotelsContainsKeyword(String keyword) {
        return hotelRepo.findAllByNameContains(keyword)
                .stream()
                .map(hotel -> {
                    HotelResponse hotelResponse = ProviderMapper.toHotelResponse(hotel) ;
                    hotelResponse.setMinPrice((int)hotelRepo.getMinPrice(hotel.getId()));
                    return hotelResponse;

                })
                .collect(Collectors.toList());
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

    public Room getRoomById(int roomId) {
        Room room = roomRepo.findById(roomId).orElseThrow(()->{
            throw new NoElementException("the room not found") ;
        }) ;
        room.setProvider(ProviderMapper.toProviderResponse(room.getHotel()));
        return room;
    }

    public void setPosition(float lng, float lat) {
        Hotel hotel = getAuthenticated() ;
        hotel.setLatitude(lat) ;
        hotel.setLongitude(lng);
        hotelRepo.save(hotel) ;
    }
    @Transactional
    public void addAmenities(List<Integer> amenities) {
        Hotel hotel = this.getAuthenticated() ;
        List<Amenitie> newAmenities = amenities.stream().map(amenitie -> amenitieRepo.findById(amenitie).get()).collect(Collectors.toList());
        newAmenities.addAll(hotel.getAmenities()) ;
        hotel.setAmenities(newAmenities);
        hotelRepo.save(hotel) ;
    }

    public List<Amenitie> getAmenities() {
        return this.getAuthenticated().getAmenities();
    }

    public List<Amenitie> getUnselectedAmenities() {
        List<Amenitie> amenitieList = amenitieRepo.findAll() ;
        List<Amenitie> hotelAmenities = this.getAuthenticated().getAmenities() ;
        List<Amenitie> unselectedAmenities = new ArrayList<>( );
        amenitieList.forEach(amenitie -> {
            if(!hotelAmenities.contains(amenitie)) {
                unselectedAmenities.add(amenitie) ;
            }
        });
        return unselectedAmenities ;
    }
    public HotelResponse getHotel(int id) {
        return ProviderMapper.toHotelResponse(hotelRepo.findById(id).get()) ;
    }
}
