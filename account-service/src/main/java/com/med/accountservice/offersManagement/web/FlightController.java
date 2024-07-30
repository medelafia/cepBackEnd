package com.med.accountservice.offersManagement.web;


import com.med.accountservice.offersManagement.dto.AvailabilityResponse;
import com.med.accountservice.offersManagement.entity.Flight;
import com.med.accountservice.offersManagement.service.FlightService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/offer/flights")
@CrossOrigin("http://localhost:5173")
public class FlightController {
    @Autowired
    private FlightService flightService ;
    @GetMapping
    public List<Flight> findAllFlights() {
        return flightService.getAllFlights() ;
    }
    @GetMapping("/{id}")
    public Flight findAllFlightsByAirlineId(@PathVariable int id){
        return flightService.getFlightById(id) ;
    }
    @GetMapping("/{id}/isAvailable")
    public ResponseEntity<AvailabilityResponse> checkAvailability(@PathVariable int id , @RequestParam int nbPersons , @RequestParam int className) {
        return new ResponseEntity<>(new AvailabilityResponse(flightService.checkAvailability(id , nbPersons , className )) , HttpStatus.OK) ;
    }
}
