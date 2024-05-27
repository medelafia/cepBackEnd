package com.med.accountservice.usersManagement.web;

import com.med.accountservice.offersManagement.entity.Flight;
import com.med.accountservice.usersManagement.entity.Airline;
import com.med.accountservice.usersManagement.service.AirlineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airlines")
@AllArgsConstructor
public class AirlineController {
    private AirlineService airlineService ;
    @GetMapping("/")
    public List<Airline> getAllAirlines() {
        return airlineService.getAllAirlines() ;
    }
    @GetMapping("/{id}")
    public Airline getAirlineById(@PathVariable int id) {
        return airlineService.getAirlineById(id);
    }
}
