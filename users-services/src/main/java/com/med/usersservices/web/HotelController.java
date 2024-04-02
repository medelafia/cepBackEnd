package com.med.usersservices.web;

import com.med.usersservices.entity.Hotel;
import com.med.usersservices.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    HotelService hotelService ;
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService ;
    }
    @GetMapping("/")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels() ;
    }
    @PostMapping("/")
    public Hotel addNewHotel(Hotel hotel) {
        return hotelService.registerNewHotel(hotel) ;
    }
}
