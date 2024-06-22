package com.med.accountservice.offersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.offersManagement.entity.Flight;
import com.med.accountservice.offersManagement.repository.FlightRepo;
import com.med.accountservice.stationsManagement.entity.Airport;
import com.med.accountservice.stationsManagement.repository.AirportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepo flightRepo ;
    @Autowired
    private AirportRepo airportRepo ;
    public List<Flight> findAllFlightsByAirlineId(int id){
        return flightRepo.findAllByAirlineId(id) ;
    }
    public List<Flight> getAllFlights() {
        return flightRepo.findAll() ;
    }

    public List<Flight> findAllRoundFlight(String startAirportId, String endAirportId, Date departDate, Date returnDate) {
        Airport startAirport = airportRepo.findById(startAirportId).orElseThrow(()->{
            throw new NoElementException("the airport not found") ;
        }) ;
        Airport endAirport = airportRepo.findById(endAirportId).orElseThrow(()->{
            throw new NoElementException("the airport not found") ;
        }) ;
        return flightRepo.findAllByDepartureDateAndReturnDateAndFromAndTo(departDate , returnDate , startAirport , endAirport) ;
    }
    public List<Flight> findAllOneWayFlights(String startAirportId , String endAirportId , Date departDate) {
        Airport startAirport = airportRepo.findById(startAirportId).orElseThrow(()->{
            throw new NoElementException("the airport not found") ;
        }) ;
        Airport endAirport = airportRepo.findById(endAirportId).orElseThrow(()->{
            throw new NoElementException("the airport not found") ;
        }) ;
        return flightRepo.findAllByDepartureDateAndFromAndTo(departDate , startAirport , endAirport) ;
    }
}
