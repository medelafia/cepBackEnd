package com.med.accountservice.offersManagement.web;


import com.med.accountservice.offersManagement.entity.OrganizedTravel;
import com.med.accountservice.offersManagement.service.BasicService;
import com.med.accountservice.offersManagement.service.OrganizedTravelsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/organizedTravel")
@AllArgsConstructor
public class OrganizedTravelController {
    private OrganizedTravelsService organizedTravelsService ;
    private BasicService<OrganizedTravel , Integer> basicService ;

    @GetMapping("/")
    public List<OrganizedTravel> findAllOrganizedTravels() {
        return basicService.findAll() ;
    }
}
