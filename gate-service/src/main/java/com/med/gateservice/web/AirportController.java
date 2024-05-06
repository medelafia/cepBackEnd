package com.med.gateservice.web;

import com.med.gateservice.dto.AirportDto;
import com.med.gateservice.entity.Airport;
import com.med.gateservice.service.AirportService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/airports/")
@CrossOrigin("http://localhost:5173")
public class AirportController {
    AirportService airportService ;
    AirportController(AirportService airportService) {
        this.airportService = airportService ;
    }
    @GetMapping("/")
    public List<Airport> getAllAirports() {
        return airportService.getAllAirport();
    }
    @GetMapping("/{id}")
    public Airport getAirportById(@PathVariable int id) {
        return airportService.getAirportById(id);
    }
    @PostMapping ("/")
    public Airport addAirport(@RequestBody AirportDto airportDto) {
        return airportService.addAirport(airportDto);
    }
}
