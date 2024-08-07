package com.med.accountservice.offersManagement.web;


import com.med.accountservice.offersManagement.entity.Room;
import com.med.accountservice.offersManagement.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offer/rooms")
@CrossOrigin("http://localhost:5173")
public class RoomController {
    @Autowired
    private RoomService roomService ;
    @PostMapping("/setAvailable")
    public Room setAvailable(@RequestParam int id) {
        return roomService.setAvailable(id) ;
    }
    @GetMapping("/isAvailable/{id}")
    public boolean checkAvailable(@PathVariable int id) {
        return roomService.checkAvailable(id);
    }
}

