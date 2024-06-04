package com.med.accountservice.stationsManagement.web;

import com.med.accountservice.stationsManagement.entity.Airport;
import com.med.accountservice.stationsManagement.service.AirportService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {
    private AirportService airportService ;
    @PostMapping("/")
    public Airport addAirport(@RequestBody  Airport airport) {
        return airportService.addAirport(airport) ;
    }
    @GetMapping("/")
    public List<Airport> getAllAirports() {
        return airportService.getAllAirport() ;
    }
}
