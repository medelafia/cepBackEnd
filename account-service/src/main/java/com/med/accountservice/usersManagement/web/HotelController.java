package com.med.accountservice.usersManagement.web;

import com.med.accountservice.offersManagement.entity.Room;
import com.med.accountservice.usersManagement.entity.Hotel;
import com.med.accountservice.usersManagement.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@CrossOrigin("http://localhost:5173")
public class HotelController {
    @Autowired
    private HotelService hotelService ;
    @PostMapping("/{id}")
    public Hotel addNewRoom(@RequestBody Room room  ,@PathVariable  int id)  {
        return hotelService.addNewRoom(id , room) ;
    }
    @GetMapping("/{id}/rooms")
    public List<Room> getAllRoomsByHotelId(@PathVariable int id) {
        return hotelService.getAllRoomsByHotelId(id);
    }
}

