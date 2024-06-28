package com.med.accountservice.usersManagement.web;

import com.med.accountservice.offersManagement.entity.OrganizedTravel;
import com.med.accountservice.offersManagement.entity.TrainTravel;
import com.med.accountservice.usersManagement.entity.TravelAgency;
import com.med.accountservice.usersManagement.service.TravelAgencyService;
import jakarta.ws.rs.Path;
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
    @PostMapping("/{id}/createTravel")
    public List<OrganizedTravel> addOrganizedTravel(@RequestBody OrganizedTravel organizedTravel, @PathVariable int id) {
        return travelAgencyService.addNewOrganizedTravel(id , organizedTravel ) ;
    }
    @GetMapping("/{id}/organizedTravels")
    public List<OrganizedTravel> getAllOrganizedTravelsByTravelsAgencyId(@PathVariable int id) {
        return travelAgencyService.getAllOrganizedTravelsByTravelAgency(id);
    }
    @PostMapping("/{id}/organizedTravels/{travel_id}")
    public void deleteOrganizedTravel(@PathVariable int id , @PathVariable int travel_id) {
        travelAgencyService.deleteOrganizedTravel(id , travel_id) ;
    }
}

