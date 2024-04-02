package com.med.offersservices.web;

import com.med.offersservices.entity.TrainTravel;
import com.med.offersservices.service.TrainTravelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainTravels")
public class TrainTravelController {
    TrainTravelService trainTravelService ;
    public TrainTravelController(TrainTravelService trainTravelService) {
        this.trainTravelService = trainTravelService ;
    }
    @PostMapping("/")
    public TrainTravel addNewProduct(TrainTravel trainTravel) {
        return trainTravelService.addNewTrainTravel(trainTravel) ;
    }
    @GetMapping("/{id}")
    public List<TrainTravel> getAllProductsByProviderId(@PathVariable int id) {
        return trainTravelService.getAllByRailWaysOperatorId(id) ;
    }
    public List<TrainTravel> getAllTrainTravels() {
        return trainTravelService.getAllTrainTravels() ;
    }
}
