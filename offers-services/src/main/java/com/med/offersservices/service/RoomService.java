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
    public List<Room> getRoomsByIds(List<Integer> ids) {
        return roomRepo.findAllById(ids) ;
    }
    public Room addNewRoom(Room room) {
        return roomRepo.save(room) ;
    }
    public void deleteRoomById(int id){
        roomRepo.deleteById(id);
    }
}
