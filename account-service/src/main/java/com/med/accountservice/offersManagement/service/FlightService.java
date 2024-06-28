package com.med.accountservice.offersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.offersManagement.entity.Flight;
import com.med.accountservice.offersManagement.repository.FlightRepo;
import com.med.accountservice.stationsManagement.entity.Airport;
import com.med.accountservice.stationsManagement.repository.AirportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.metal.MetalBorders;
import java.sql.Date;
import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepo flightRepo ;
    @Autowired
    private AirportRepo airportRepo ;
    public Flight getFlightById(int id) {
        if(flightRepo.findById(id).isPresent()) {
            return flightRepo.findById(id).get()  ;
        }else {
            throw new NoElementException("the flight not found") ;
        }
    }
    public List<Flight> findAllFlightsByAirlineId(int id){
        return flightRepo.findAllByAirlineId(id) ;
    }
    public List<Flight> getAllFlights() {
        return flightRepo.findAll() ;
    }

    public List<Flight> findAllRoundFlight(int startAirportId, int endAirportId, Date departDate, Date returnDate) {
        if(airportRepo.findById(startAirportId).isPresent() && airportRepo.findById(endAirportId).isPresent()) {
            Airport startAirport = airportRepo.findById(startAirportId).get() ;
            Airport endAirport = airportRepo.findById(endAirportId).get( );
            return flightRepo.findAllByDepartureDateAndReturnDateAndFromAndTo(departDate , returnDate , startAirport , endAirport) ;
        }else {
            throw new NoElementException("airports not found") ;
        }
    }
    public List<Flight> findAllOneWayFlights(int startAirportId , int endAirportId , Date departDate) {
        if(airportRepo.findById(startAirportId).isPresent() && airportRepo.findById(endAirportId).isPresent()) {
            Airport startAirport = airportRepo.findById(startAirportId).get() ;
            Airport endAirport = airportRepo.findById(endAirportId).get( );
            return flightRepo.findAllByDepartureDateAndFromAndTo(departDate , startAirport , endAirport) ;
        }else {
            throw new NoElementException("airports not found") ;
        }
    }
}
