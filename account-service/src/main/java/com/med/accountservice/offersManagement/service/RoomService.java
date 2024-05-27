package com.med.accountservice.offersManagement.service;

import com.med.accountservice.offersManagement.repository.RoomRepo;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private RoomRepo roomRepo ;
    public RoomService(RoomRepo roomRepo){
        this.roomRepo = roomRepo ;
    }
}
