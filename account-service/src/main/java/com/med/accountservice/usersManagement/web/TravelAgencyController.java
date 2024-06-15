package com.med.accountservice.usersManagement.web;

import com.med.accountservice.offersManagement.entity.OrganizedTravel;
import com.med.accountservice.offersManagement.entity.TrainTravel;
import com.med.accountservice.usersManagement.entity.TravelAgency;
import com.med.accountservice.usersManagement.service.TravelAgencyService;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travelAgencies")
@CrossOrigin("http://localhost:5173")
public class TravelAgencyController {
    @Autowired
    private TravelAgencyService travelAgencyService ;
    @PostMapping("/{id}")
    public TravelAgency travelAgency(@RequestBody OrganizedTravel organizedTravel, @PathVariable int id) {
        return travelAgencyService.addNewOrganizedTravel(id , organizedTravel ) ;
    }
    @GetMapping("/{id}/organizedTravels")
    public List<OrganizedTravel> getAllOrganizedTravelsByTravelsAgencyId(@PathVariable int id) {
        return travelAgencyService.getAllOrganizedTravelsByTravelAgency(id);
    }
}

