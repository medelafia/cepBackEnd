package com.med.offersservices.web;

import com.med.offersservices.entity.Flight;
import com.med.offersservices.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/flights/")
public class FlightController {
    FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/{id}")
    public List<Flight> getAllByProviderId(@PathVariable int id) {
        return flightService.getAllFlightsByAirlineId(id);
    }

    @PostMapping("/")
    public Flight addNewProduct(Flight flight) {
        return flightService.addNewFlight(flight) ;
    }
    @GetMapping("/")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights() ;
    }
}