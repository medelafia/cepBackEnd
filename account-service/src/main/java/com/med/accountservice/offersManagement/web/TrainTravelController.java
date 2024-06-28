package com.med.accountservice.offersManagement.web;


import com.med.accountservice.offersManagement.entity.TrainTravel;
import com.med.accountservice.offersManagement.service.TrainTravelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offer/trainTravels")
@CrossOrigin("http://localhost:5173")
public class TrainTravelController {
    @Autowired
    private TrainTravelService trainTravelService ;
    @GetMapping("/")
    public List<TrainTravel> getAllTrainTravels() {
        return trainTravelService.getAllTrainTravels() ;
    }
    @GetMapping("/{id}")
    public TrainTravel getTrainTravelById(@PathVariable int id ) {
        return trainTravelService.getTrainTravelById(id) ;
    }
}
