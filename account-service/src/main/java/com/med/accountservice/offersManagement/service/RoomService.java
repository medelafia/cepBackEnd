package com.med.accountservice.offersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.offersManagement.entity.Room;
import com.med.accountservice.offersManagement.repository.RoomRepo;
import com.med.accountservice.usersManagement.mapper.ProviderMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    private RoomRepo roomRepo ;
    public RoomService(RoomRepo roomRepo){
        this.roomRepo = roomRepo ;
    }
    public List<Room> findAllAvailableRooms(int id) {
        List<Room> rooms = roomRepo.findAllByHotelId(id) ;
        rooms.stream().filter(room->{
            return room.isAvailable() ;
        }).toList();
        return rooms.stream().map(room -> {
            room.setProvider(ProviderMapper.toProviderResponse(room.getHotel()));
            return room ;
        }).collect(Collectors.toList());
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

    public Room getRoomById(int id) {
        if(roomRepo.findById(id).isPresent()) {
            return roomRepo.findById(id).get() ;
        }else {
            throw new NoElementException("the room not found") ;
        }
    }
}
