package com.med.accountservice.offersManagement.service;

import com.med.accountservice.offersManagement.entity.Flight;
import com.med.accountservice.offersManagement.repository.FlightRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    private FlightRepo flightRepo ;
    public FlightService(FlightRepo flightRepo) {
        this.flightRepo = flightRepo ;
    }
    public List<Flight> findAllFlightsByAirlineId(int id){
        return flightRepo.findAllByAirlineId(id) ;
    }
}
