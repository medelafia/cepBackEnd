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
@RequestMapping("/flights")
@CrossOrigin("http://localhost:5173")
public class FlightController {
    @Autowired
    private FlightService flightService ;
    @GetMapping("/")
    public List<Flight> findAllFlights() {
        return flightService.getAllFlights() ;
    }
    @GetMapping("/{id}")
    public List<Flight> findAllFlightsByAirlineId(@PathVariable int id){
        return flightService.findAllFlightsByAirlineId(id) ;
    }
    @GetMapping("/getRoundTrip")
    public List<Flight> findAllRoundFlight(@RequestParam String startAirport ,
                                           @RequestParam String endAirport ,
                                           @RequestParam Date departDate ,
                                           @RequestParam Date returnDate ) {
        return flightService.findAllRoundFlight(startAirport , endAirport , departDate , returnDate ) ;
    }
    @GetMapping("/getOneWayTrip")
    public List<Flight> findAllOneWayFlights(@RequestParam String startAirport ,
                                             @RequestParam String endAirport ,
                                             @RequestParam Date departDate)  {
        return flightService.findAllOneWayFlights(startAirport , endAirport , departDate) ;
    }
}
