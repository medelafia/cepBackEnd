package com.med.offersservices.service;

import com.med.offersservices.entity.Flight;
import com.med.offersservices.feignClient.GateRepo;
import com.med.offersservices.repositry.FlightRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    FlightRepo flightRepo ;
    GateRepo gateRepo ;
    public FlightService(FlightRepo flightRepo , GateRepo gateRepo) {
        this.flightRepo = flightRepo ;
        this.gateRepo = gateRepo ;
    }
    public void deleteFlightById(int id) {
        flightRepo.deleteById(id);
    }
    public List<Flight> getAllFlightsByAirlineId( int id) {
        List<Flight> flights = flightRepo.findAllByAirlineId(id) ;
        flights.forEach(flight -> {
            flight.setStartAirport(gateRepo.getAirportById(flight.getStartAirportId()));
            flight.setArrivedAirport(gateRepo.getAirportById(flight.getArrivedAirportId()));
        });
        return  flights;
    }
    public Flight addNewFlight(Flight flight) {
        return flightRepo.save(flight) ;
    }
    public List<Flight> getAllFlights() {
        List<Flight> flights = flightRepo.findAll() ;
        flights.forEach(flight -> {
            flight.setStartAirport(gateRepo.getAirportById(flight.getStartAirportId()));
            flight.setArrivedAirport(gateRepo.getAirportById(flight.getArrivedAirportId()));
        });
        return flights ;
    }
}
