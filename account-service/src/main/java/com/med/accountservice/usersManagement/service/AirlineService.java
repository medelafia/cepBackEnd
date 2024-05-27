package com.med.accountservice.usersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.usersManagement.entity.Airline;
import com.med.accountservice.usersManagement.repository.AirlineRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AirlineService {
    private AirlineRepo airlineRepo  ;
    public List<Airline> getAllAirlines() {
        return airlineRepo.findAll() ;
    }
    public Airline getAirlineById(int id) {
        return airlineRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("airline not found") ;
        }) ;
    }
}
