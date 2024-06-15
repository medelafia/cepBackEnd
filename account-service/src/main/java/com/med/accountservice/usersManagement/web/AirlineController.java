package com.med.accountservice.usersManagement.web;

import com.med.accountservice.offersManagement.entity.Flight;
import com.med.accountservice.usersManagement.entity.Airline;
import com.med.accountservice.usersManagement.service.AirlineService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airlines")
public class AirlineController {
    @Autowired
    private AirlineService airlineService ;
    @GetMapping("/")
    public List<Airline> getAllAirlines() {
        return airlineService.getAllAirlines() ;
    }
    @PostMapping("/{providerId}")
    public Airline createFlight(@PathVariable int providerId , @RequestBody Flight flight) {
        return airlineService.addFlight(providerId , flight) ;
    }
    @PostMapping("/")
    public void deleteFlightById() {
    }
    @GetMapping("/{id}/flights")
    public List<Flight> getAllFlightsByAirlineId(@PathVariable int id ) {
        return airlineService.getAllFlightsByAirlineId(id);
    }
}
