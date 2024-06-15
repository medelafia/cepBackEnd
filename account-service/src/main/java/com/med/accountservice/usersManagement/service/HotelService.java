package com.med.accountservice.usersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.offersManagement.entity.Room;
import com.med.accountservice.offersManagement.repository.RoomRepo;
import com.med.accountservice.usersManagement.entity.Hotel;
import com.med.accountservice.usersManagement.repository.HotelRepo;
import org.apache.coyote.http11.HeadersTooLargeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.HostInfoEnvironmentPostProcessor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        hotel.createNewRoom(roomRepo.save(room) ) ;
        return hotel ;
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
}
