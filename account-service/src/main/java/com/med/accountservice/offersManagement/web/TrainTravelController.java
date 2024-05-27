package com.med.accountservice.offersManagement.web;


import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.med.accountservice.offersManagement.entity.TrainTravel;
import com.med.accountservice.offersManagement.service.BasicService;
import com.med.accountservice.offersManagement.service.TrainTravelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trainTravels")
@AllArgsConstructor
public class TrainTravelController {
    private TrainTravelService trainTravelService ;
    private BasicService<TrainTravel , Integer> basicService ;
    @GetMapping("/")
    public List<TrainTravel> findAllTrainTravels() {
        return basicService.findAll() ;
    }

}
