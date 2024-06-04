package com.med.accountservice.usersManagement.service;

import com.med.accountservice.usersManagement.entity.Hotel;
import com.med.accountservice.usersManagement.repository.HotelRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelService {
    private HotelRepo hotelRepo ;
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll() ;
    }
}
