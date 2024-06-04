package com.med.accountservice.offersManagement.web;


import com.med.accountservice.offersManagement.entity.Flight;
import com.med.accountservice.offersManagement.service.BasicService;
import com.med.accountservice.offersManagement.service.FlightService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private FlightService flightService ;
    public BasicService<Flight , Integer > basicService ;
    public FlightController(FlightService flightService , BasicService basicService) {
        this.flightService = flightService ;
        this.basicService = basicService ;
    }
    @GetMapping("/")
    public List<Flight> findAllFlights() {
        return basicService.findAll() ;
    }
    @GetMapping("/{id}")
    public List<Flight> findAllFlightsByAirlineId(@PathVariable int id){
        return flightService.findAllFlightsByAirlineId(id) ;
    }

}
