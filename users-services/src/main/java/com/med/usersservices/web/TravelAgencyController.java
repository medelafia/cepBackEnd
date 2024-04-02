package com.med.usersservices.web;

import com.med.usersservices.entity.TravelAgency;
import com.med.usersservices.service.TravelAgencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/travelAgencies")
public class TravelAgencyController {
    TravelAgencyService travelAgencyService ;
    public TravelAgencyController(TravelAgencyService travelAgencyService) {
        this.travelAgencyService = travelAgencyService ;
    }
    @PostMapping("/")
    public TravelAgency addNewTravelAgency(TravelAgency travelAgency) {
        return travelAgencyService.registerNewTravelAgency(travelAgency);
    }
    @GetMapping("/")
    public List<TravelAgency> getAllTravelsAgencies() {
        return travelAgencyService.getAllTravelsAgencies() ;
    }
}
