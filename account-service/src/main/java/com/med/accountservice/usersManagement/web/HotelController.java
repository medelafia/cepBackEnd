package com.med.accountservice.usersManagement.web;

import com.med.accountservice.usersManagement.entity.Hotel;
import com.med.accountservice.usersManagement.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@AllArgsConstructor
public class HotelController {
    private HotelService hotelService ;
    @GetMapping("/")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels() ;
    }
}
