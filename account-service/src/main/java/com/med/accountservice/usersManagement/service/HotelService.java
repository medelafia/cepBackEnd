package com.med.accountservice.usersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.offersManagement.entity.Room;
import com.med.accountservice.offersManagement.repository.RoomRepo;
import com.med.accountservice.usersManagement.dto.HotelPosition;
import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.entity.Hotel;
import com.med.accountservice.usersManagement.mapper.ProviderMapper;
import com.med.accountservice.usersManagement.repository.HotelRepo;
import org.apache.coyote.http11.HeadersTooLargeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.HostInfoEnvironmentPostProcessor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {
    @Autowired
    private HotelRepo hotelRepo ;
    @Autowired
    private RoomRepo roomRepo ;
    public Hotel addNewRoom(int providerId , Room room)  {
        Hotel hotel = hotelRepo.findById(providerId).orElseThrow(()->{
            throw new NoElementException("the hotel not found") ;
        }) ;
        hotel.createNewRoom(roomRepo.save(room)) ;
        return hotelRepo.save(hotel) ;
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
}
