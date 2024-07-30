package com.med.accountservice.usersManagement.web;

import com.med.accountservice.offersManagement.entity.Flight;
import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.entity.Airline;
import com.med.accountservice.usersManagement.service.AirlineService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airlines")
@CrossOrigin("http://localhost:5173")
public class AirlineController {
    @Autowired
    private AirlineService airlineService ;
    @GetMapping("/")
    public List<ProviderResponse> getAllAirlines() {
        return airlineService.getAllAirlines() ;
    }
    @PostMapping("/createFlight")
    public List<Flight> createFlight( @RequestBody Flight flight) {
        return airlineService.addFlight(flight) ;
    }
    @GetMapping("/flights")
    public List<Flight> getAllFlightsByAirlineId() {
        return airlineService.getAllFlights();
    }
    @PostMapping("/flights/{flight_id}")
    public void deleteFlight(@PathVariable int flight_id) {
        airlineService.deleteFlight(flight_id );
    }
}
