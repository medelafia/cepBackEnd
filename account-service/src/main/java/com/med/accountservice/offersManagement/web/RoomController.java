package com.med.accountservice.offersManagement.web;


import com.med.accountservice.offersManagement.entity.Room;
import com.med.accountservice.offersManagement.service.BasicService;
import com.med.accountservice.offersManagement.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private RoomService roomService ;
    private BasicService<Room , Integer> basicService ;
    public RoomController(BasicService basicService , RoomService roomService ) {
        this.basicService = basicService ;
        this.roomService = roomService ;
    }
    @GetMapping("/")
    public List<Room>  findAllRooms() {
        return basicService.findAll() ;
    }
    @GetMapping("/getAvailableRooms/{id}")
    public List<Room> findAllAvailableRoomsByHotelId(@PathVariable int id) {
        return roomService.findAllAvailableRooms(id);
    }
    @PostMapping("/setAvailable")
    public Room setAvailable(@RequestParam int id) {
        return roomService.setAvailable(id) ;
    }
    @GetMapping("/isAvailable/{id}")
    public boolean checkAvailable(@PathVariable int id) {
        return roomService.checkAvailable(id);
    }
    @PostMapping("/")
    public Room addRoom(@RequestBody Room room){
        return basicService.save(room) ;
    }
}
