package com.med.gateservice.web;

import com.med.gateservice.entity.TrainStation;
import com.med.gateservice.service.TrainStationService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trainStations/")
public class TrainStationController {
    TrainStationService trainStationService ;
    public TrainStationController(TrainStationService trainStationService){
        this.trainStationService = trainStationService ;
    }
    @GetMapping("/")
    public List<TrainStation> getAllTrainStation() {
        return trainStationService.getAllTrainStations();
    }
    @GetMapping("/{id}")
    public TrainStation getTrainStationById(@PathVariable int id) {
        return trainStationService.getTrainStationById(id);
    }
    @PostMapping("/")
    public TrainStation addTrainStation(@RequestBody TrainStation trainStation) {
        return trainStationService.addTrainStation(trainStation) ;
    }
}
