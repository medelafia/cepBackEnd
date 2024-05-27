package com.med.accountservice.offersManagement.web;


import com.med.accountservice.offersManagement.entity.Flight;
import com.med.accountservice.offersManagement.service.BasicService;
import com.med.accountservice.offersManagement.service.FlightService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
@AllArgsConstructor
public class FlightController {
    private FlightService flightService ;
    public BasicService<Flight , Integer > basicService ;
    @GetMapping("/")
    public List<Flight> findAllFlights() {
        return basicService.findAll() ;
    }

}
