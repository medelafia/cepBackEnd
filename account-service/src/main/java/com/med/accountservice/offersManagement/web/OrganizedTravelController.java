package com.med.accountservice.offersManagement.web;


import com.med.accountservice.offersManagement.entity.OrganizedTravel;
import com.med.accountservice.offersManagement.service.OrganizedTravelsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/organizedTravel")
@CrossOrigin("http://localhost:5173")
public class OrganizedTravelController {
    private OrganizedTravelsService organizedTravelsService ;

    @GetMapping("/")
    public List<OrganizedTravel> findAllOrganizedTravels() {
        return organizedTravelsService.getAllOrganizedTravels() ;
    }
}
