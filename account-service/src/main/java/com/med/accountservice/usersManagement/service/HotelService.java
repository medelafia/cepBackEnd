package com.med.accountservice.usersManagement.service;

import com.med.accountservice.usersManagement.repository.HotelRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HotelService {
    private HotelRepo hotelRepo ;
}
