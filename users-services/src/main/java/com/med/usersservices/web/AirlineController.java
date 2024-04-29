package com.med.usersservices.web;

import com.med.usersservices.entity.Airline;
import com.med.usersservices.service.AirlineServices;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airlines")
public class AirlineController {
    AirlineServices airlineServices ;
    public AirlineController(AirlineServices airlineServices) {
        this.airlineServices = airlineServices ;
    }
    @GetMapping("/")
    public List<Airline> getAllAirlines() {
        return airlineServices.getAllAirlines() ;
    }
}