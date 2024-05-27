package com.med.accountservice.offersManagement.service;

import com.med.accountservice.offersManagement.repository.FlightRepo;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    private FlightRepo flightRepo ;
    public FlightService(FlightRepo flightRepo) {
        this.flightRepo = flightRepo ;
    }
}
