package com.med.accountservice.usersManagement.web;
import com.med.accountservice.offersManagement.entity.OrganizedTravel;
import com.med.accountservice.usersManagement.service.TravelAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
@RequestMapping("/travelAgencies")
@CrossOrigin("http://localhost:5173")
public class TravelAgencyController {
    @Autowired
    private TravelAgencyService travelAgencyService ;
    @PostMapping("/createTravel")
    public List<OrganizedTravel> addOrganizedTravel(@RequestPart("cover") MultipartFile cover, @RequestPart("travel") OrganizedTravel organizedTravel) {
        return travelAgencyService.addNewOrganizedTravel(cover , organizedTravel) ;
    }
    @GetMapping("/organizedTravels")
    public List<OrganizedTravel> getAllOrganizedTravels() {
        return travelAgencyService.getAllOrganizedTravels();
    }
    @PostMapping("/organizedTravels/{travel_id}")
    public void deleteOrganizedTravel(@PathVariable int travel_id) {
        travelAgencyService.deleteOrganizedTravel(travel_id) ;
    }
}

