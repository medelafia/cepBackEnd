package com.med.accountservice.usersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.offersManagement.entity.Flight;
import com.med.accountservice.offersManagement.entity.TrainTravel;
import com.med.accountservice.offersManagement.entity.TravelClass;
import com.med.accountservice.offersManagement.repository.FlightRepo;
import com.med.accountservice.offersManagement.repository.TravelClassRepo;
import com.med.accountservice.stationsManagement.repository.AirportRepo;
import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.entity.Airline;
import com.med.accountservice.usersManagement.mapper.ProviderMapper;
import com.med.accountservice.usersManagement.repository.AirlineRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private TravelClassRepo travelClassRepo ;

    private Airline getAuthenticatedAirline(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName() ;
        Airline airline = airlineRepo.findByUsername(username).get();
        return airline ;
    }
    public List<ProviderResponse> getAllAirlines() {
        return airlineRepo.findAll().stream().map(airline -> {
            return ProviderMapper.toProviderResponse(airline);
        }).collect(Collectors.toList());
    }
    public List<Flight> addFlight(Flight flight) {
        Airline airline = this.getAuthenticatedAirline() ;
        flight.setFrom(airportRepo.findById(flight.getFrom().getId()).get());
        flight.setTo(airportRepo.findById(flight.getTo().getId()).get());
        List<TravelClass> travelClasses = new ArrayList<>() ;
        flight.getFlightClasses().forEach(travelClass ->  {
            travelClasses.add(travelClassRepo.save(travelClass));
        });
        flight.setFlightClasses(travelClasses);
        flight.setAirline(airline);
        airline.getFlights().add(flightRepo.save(flight)) ;
        airline = airlineRepo.save(airline) ;
        return airline.getFlights() ;
    }
    public List<Flight> getAllFlightsByAirlineId() {
        return this.getAuthenticatedAirline().getFlights() ;
    }

    public void deleteFlight(int flightId) {
        Airline airline = this.getAuthenticatedAirline() ;
        if(flightRepo.findById(flightId).isPresent()) {
            Flight flight = flightRepo.findById(flightId).get() ;
            if(airline.getFlights().contains(flight)) {
                flightRepo.deleteById(flightId);
            }else {
                throw new NoElementException("the airline doesn't have this flight") ;
            }
        }else {
            throw new NoElementException("the flight not exist") ;
        }
    }

    public List<Flight> getAllFlights() {
        return this.getAuthenticatedAirline().getFlights() ;
    }
}
