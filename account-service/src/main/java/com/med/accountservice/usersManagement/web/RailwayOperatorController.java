package com.med.accountservice.usersManagement.web;

import com.med.accountservice.offersManagement.entity.TrainTravel;
import com.med.accountservice.usersManagement.entity.RailwayOperator;
import com.med.accountservice.usersManagement.service.RailwayOperatorService;
import com.netflix.discovery.converters.Auto;
import lombok.AllArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/railwaysOperators")
@CrossOrigin("http://localhost:5173")
public class RailwayOperatorController {
    @Autowired
    private RailwayOperatorService railwayOperatorService ;
    @PostMapping("/{id}/createTravel")
    public List<TrainTravel> addTrainTravel(@RequestBody TrainTravel trainTravel , @PathVariable int id) {
        return railwayOperatorService.addNewTrainTravel(id , trainTravel) ;
    }
    @GetMapping("/{id}/trainTravels")
    public List<TrainTravel> getAllTrainTravelsByRwO(@PathVariable  int id) {
        return railwayOperatorService.getAllTrainTravelsByRwO(id) ;
    }

}
