package com.med.offersservices.service;

import com.med.offersservices.entity.Room;
import com.med.offersservices.repositry.RoomRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    RoomRepo roomRepo ;
    public RoomService(RoomRepo roomRepo) {
        this.roomRepo = roomRepo ;
    }
    public List<Room> getRoomsByHotelId(int id) {
        return roomRepo.findAllByHotelId(id) ;
    }
    public Room addNewRoom(Room room) {
        return roomRepo.save(room) ;
    }
    public void deleteRoomById(int id){
        roomRepo.deleteById(id);
    }
    public List<Room> getAllRooms() {
        return roomRepo.findAll() ;
    }
}
