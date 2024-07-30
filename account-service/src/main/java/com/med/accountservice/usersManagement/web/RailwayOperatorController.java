package com.med.accountservice.usersManagement.web;

import com.med.accountservice.offersManagement.entity.TrainTravel;
import com.med.accountservice.usersManagement.entity.RailwayOperator;
import com.med.accountservice.usersManagement.service.RailwayOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/railwaysOperators")
@CrossOrigin("http://localhost:5173")
public class RailwayOperatorController {
    @Autowired
    private RailwayOperatorService railwayOperatorService ;
    @PostMapping("/createTravel")
    public List<TrainTravel> addTrainTravel(@RequestBody TrainTravel trainTravel) {
        return railwayOperatorService.addNewTrainTravel(trainTravel) ;
    }
    @GetMapping("/trainTravels")
    public List<TrainTravel> getAllTrainTravels() {
        return railwayOperatorService.getAllTrainTravels() ;
    }

}
