package com.med.usersservices.service;

import com.med.usersservices.entity.Airline;
import com.med.usersservices.feignRepo.OffersRepo;
import com.med.usersservices.repository.AirlineRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineServices {
    AirlineRepo airlineRepo ;
    OffersRepo offersRepo ;
    public AirlineServices(AirlineRepo airlineRepo , OffersRepo offersRepo ) {
        this.airlineRepo = airlineRepo ;
        this.offersRepo = offersRepo ;
    }
    public Airline registerNewAirline(Airline airline) {
        return airlineRepo.save(airline) ;
    }
    public List<Airline> getAllAirlines() {
        List<Airline> airlines = airlineRepo.findAll() ;
        airlines.forEach(airline -> {
            airline.setFlights(offersRepo.getAllFlightsByAirlineId(airline.getId()));
        });
        return airlines ;
    }
    public void deleteAirlineById(int id) {
        airlineRepo.deleteById(id);
    }
}
