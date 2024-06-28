package com.med.accountservice.offersManagement.web;


import com.med.accountservice.offersManagement.entity.Flight;
import com.med.accountservice.offersManagement.service.FlightService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/offer/flights")
@CrossOrigin("http://localhost:5173")
public class FlightController {
    @Autowired
    private FlightService flightService ;
    @GetMapping("/")
    public List<Flight> findAllFlights() {
        return flightService.getAllFlights() ;
    }
    @GetMapping("/{id}")
    public Flight findAllFlightsByAirlineId(@PathVariable int id){
        return flightService.getFlightById(id) ;
    }
    @GetMapping("/getRoundTrip")
    public List<Flight> findAllRoundFlight(@RequestParam int from  ,
                                           @RequestParam int to ,
                                           @RequestParam Date depDate ,
                                           @RequestParam Date returnDate ) {
        return flightService.findAllRoundFlight(from , to , depDate , returnDate ) ;
    }
    @GetMapping("/getOneWayTrip")
    public List<Flight> findAllOneWayFlights(@RequestParam int from ,
                                             @RequestParam int to ,
                                             @RequestParam Date depDate)  {
        return flightService.findAllOneWayFlights(from , to , depDate) ;
    }
}
