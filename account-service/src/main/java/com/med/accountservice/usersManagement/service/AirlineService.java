package com.med.accountservice.usersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.offersManagement.entity.Flight;
import com.med.accountservice.offersManagement.entity.TrainTravel;
import com.med.accountservice.offersManagement.repository.FlightRepo;
import com.med.accountservice.usersManagement.entity.Airline;
import com.med.accountservice.usersManagement.repository.AirlineRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService {
    @Autowired
    private AirlineRepo airlineRepo  ;
    @Autowired
    private FlightRepo flightRepo ;
    public List<Airline> getAllAirlines() {
        return airlineRepo.findAll() ;
    }
    public Airline getAirlineById(int id) {
        return airlineRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("airline not found") ;
        }) ;
    }
    public Airline addFlight(int providerId , Flight flight) {
        Airline airline = airlineRepo.findById(providerId).orElseThrow(()->{
            throw new NoElementException("the airline not found") ;
        }) ;
        airline.createNewFlight(flightRepo.save(flight)) ;
        return airlineRepo.save(airline) ;
    }
    public void deleteFlightById(int providerId , int flightId) {
        Airline airline = airlineRepo.findById(providerId).orElseThrow(()->{
            throw new NoElementException("the airline not found") ;
        }) ;
        if( airline != null ) {
            airline.deleteFlightById(flightId) ;
            airlineRepo.save(airline) ;
        }
    }
    public List<Flight> getAllFlightsByAirlineId(int id) {
        Airline airline = airlineRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("the airline not found") ;
        });
        if( airline != null) {
            return airline.getFlights() ;
        }
        return null ;
    }
}
