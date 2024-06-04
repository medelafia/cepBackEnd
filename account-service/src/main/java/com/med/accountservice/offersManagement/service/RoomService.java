package com.med.accountservice.offersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.offersManagement.entity.Room;
import com.med.accountservice.offersManagement.repository.RoomRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private RoomRepo roomRepo ;
    public RoomService(RoomRepo roomRepo){
        this.roomRepo = roomRepo ;
    }
    public List<Room> findAllAvailableRooms(int id) {
        return roomRepo.findAllByAvailableAAndHotelId(id) ;
    }
    public Room setAvailable(int id) {
        Room room = roomRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("room not exist") ;
        });
        room.setAvailable(!room.isAvailable());
        return roomRepo.save(room) ;
    }
    public boolean checkAvailable(int id) {
        Room room = roomRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("room not exist") ;
        });
        return room.isAvailable() ;
    }
}
