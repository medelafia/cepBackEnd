package com.med.offersservices.web;
import com.med.offersservices.entity.Room;
import com.med.offersservices.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms/")
public class RoomController {
    RoomService roomService ;
    public RoomController(RoomService roomService) {
        this.roomService = roomService ;
    }
    @PostMapping("/")
    public Room addNewRoom(Room room) {
        return roomService.addNewRoom(room) ;
    }
    @GetMapping("/{id}")
    public List<Room> getAllProductsByProviderId(@PathVariable int id) {
        return roomService.getRoomsByHotelId(id) ;
    }
    @GetMapping("/")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms() ;
    }
}
