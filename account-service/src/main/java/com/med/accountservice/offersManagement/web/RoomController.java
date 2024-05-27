package com.med.accountservice.offersManagement.web;


import com.med.accountservice.offersManagement.entity.Room;
import com.med.accountservice.offersManagement.service.BasicService;
import com.med.accountservice.offersManagement.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@AllArgsConstructor
public class RoomController {
    private RoomService roomService ;
    private BasicService<Room , Integer> basicService ;
    @GetMapping("/")
    public List<Room>  findAllRooms() {
        return basicService.findAll() ;
    }
}
