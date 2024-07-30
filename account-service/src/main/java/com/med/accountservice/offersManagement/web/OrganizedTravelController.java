package com.med.accountservice.offersManagement.web;


import com.med.accountservice.offersManagement.entity.OrganizedTravel;
import com.med.accountservice.offersManagement.service.OrganizedTravelsService;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/offer/organizedTravels")
@CrossOrigin("http://localhost:5173")
public class OrganizedTravelController {
    private OrganizedTravelsService organizedTravelsService ;

    @GetMapping("/{id}")
    public OrganizedTravel getOrganizedTravelById(@PathVariable int id ) {
        return organizedTravelsService.getOrganizedTravelById(id) ;
    }
}
