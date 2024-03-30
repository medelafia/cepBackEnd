package com.med.offersservices.service;

import com.med.offersservices.entity.Flight;
import com.med.offersservices.repositry.FlightRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    FlightRepo flightRepo ;
    public FlightService(FlightRepo flightRepo) {
        this.flightRepo = flightRepo ;
    }
    public void deleteFlightById(int id) {
        flightRepo.deleteById(id);
    }
    public List<Flight> getFlightsByIds(List<Integer> ids) {
        return flightRepo.findAllById(ids) ;
    }
    public List<Flight> getAllFlightsByAirlineId( int id) {
        return flightRepo.findAllByAirlineId(id) ;
    }
    public Flight addNewFlight(Flight flight) {
        return flightRepo.save(flight) ;
    }
}
