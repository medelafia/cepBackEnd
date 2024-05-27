package com.med.accountservice.stationsManagement.service;

import com.med.accountservice.stationsManagement.entity.Airport;
import com.med.accountservice.stationsManagement.repository.AirportRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class AirportService {
    private AirportRepo airportRepo ;
    public List<Airport> getAllAirport() {
        return airportRepo.findAll() ;
    }
    public Airport addAirport(Airport airport) {
        return airportRepo.save(airport) ;
    }
}
