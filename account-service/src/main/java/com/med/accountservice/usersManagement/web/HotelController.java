package com.med.accountservice.usersManagement.web;

import com.med.accountservice.usersManagement.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
@AllArgsConstructor
public class HotelController {
    private HotelService hotelService ;
}
