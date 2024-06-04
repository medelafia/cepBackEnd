package com.med.accountservice.stationsManagement.web;

import com.med.accountservice.stationsManagement.entity.TrainStation;
import com.med.accountservice.stationsManagement.service.TrainStationService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainStations")
public class TrainStationController {
    private TrainStationService trainStationService ;
    @PostMapping("/")
    public TrainStation addTrainTravel(@RequestBody TrainStation trainStation) {
        return trainStationService.addTrainStation(trainStation ) ;
    }
    @GetMapping("/")
    public List<TrainStation> getAllTrainStations() {
        return trainStationService.getAllTrainStations()  ;
    }
}
