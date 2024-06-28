package com.med.accountservice.usersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.offersManagement.entity.Flight;
import com.med.accountservice.offersManagement.entity.TrainTravel;
import com.med.accountservice.offersManagement.repository.FlightRepo;
import com.med.accountservice.stationsManagement.repository.AirportRepo;
import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.entity.Airline;
import com.med.accountservice.usersManagement.mapper.ProviderMapper;
import com.med.accountservice.usersManagement.repository.AirlineRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirlineService {
    @Autowired
    private AirlineRepo airlineRepo  ;
    @Autowired
    private FlightRepo flightRepo ;
    @Autowired
    private AirportRepo airportRepo ;
    public List<ProviderResponse> getAllAirlines() {
        return airlineRepo.findAll().stream().map(airline -> {
            return ProviderMapper.toProviderResponse(airline);
        }).collect(Collectors.toList());
    }
    public Airline getAirlineById(int id) {
        return airlineRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("airline not found") ;
        }) ;
    }
    public List<Flight> addFlight(int providerId , Flight flight) {
        if(airlineRepo.findById(providerId).isPresent()) {
            Airline airline = airlineRepo.findById(providerId).get() ;
            flight.setFrom(airportRepo.findById(flight.getFrom().getId()).get());
            flight.setTo(airportRepo.findById(flight.getTo().getId()).get());
            airline.getFlights().add(flightRepo.save(flight)) ;
            airline = airlineRepo.save(airline) ;
            return airline.getFlights() ;
        }else {
            throw new NoElementException("the airline not found") ;
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

    public void deleteFlight(int id, int flightId) {
        if(airlineRepo.findById(id).isPresent()) {
            Airline airline = airlineRepo.findById(id).get() ;
            if(flightRepo.findById(flightId).isPresent()) {
                Flight flight = flightRepo.findById(flightId).get() ;
                if(airline.getFlights().contains(flight)) {
                    airline.setFlights(airline.getFlights().stream().filter(f -> f.getId() != flightId).collect(Collectors.toList()));
                    airlineRepo.save(airline) ;
                    flightRepo.deleteById(flightId);
                }else {
                    throw new NoElementException("the airline doesn't have this flight") ;
                }
            }else {
                throw new NoElementException("the flight not exist") ;
            }
        }else {
            throw new NoElementException("the airline not exist") ;
        }
    }
}
