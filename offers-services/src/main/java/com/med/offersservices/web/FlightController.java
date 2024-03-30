package com.med.offersservices.web;

import com.med.offersservices.entity.Flight;
import com.med.offersservices.service.FlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/flights/")
public class FlightController {
    FlightService flightService ;
    public FlightController(FlightService flightService) {
        this.flightService = flightService ;
    }
    @GetMapping("/{id}")
    public List<Flight> getAllFlightsByAirlineId(@PathVariable int id) {
        return flightService.getAllFlightsByAirlineId(id) ; 
    }
}
