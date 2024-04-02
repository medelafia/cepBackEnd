package com.med.offersservices.web;

import com.med.offersservices.entity.OrganizedTravel;
import com.med.offersservices.service.OrganizedTravelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizedTravels/")
public class OrganizedTravelController {
    OrganizedTravelService organizedTravelService ;
    public OrganizedTravelController(OrganizedTravelService organizedTravelService ) {
        this.organizedTravelService = organizedTravelService ;
    }
    @PostMapping("/")
    public OrganizedTravel addNewOrganizedTravel(OrganizedTravel organizedTravel) {
        return organizedTravelService.addNewOrganizedTravel(organizedTravel) ;
    }
    @GetMapping("/{id}")
    public List<OrganizedTravel> getAllProductsByProviderId(@PathVariable int id ){
        return organizedTravelService.getOrganizedTravelsByTravelAgencyId(id) ;
    }
    @GetMapping("/")
    public List<OrganizedTravel> getAllOrganizedTravels() {
        return organizedTravelService.getAllOrganizedTravels() ;
    }
}
