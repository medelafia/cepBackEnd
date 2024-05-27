package com.med.accountservice.stationsManagement.service;

import com.med.accountservice.stationsManagement.entity.TrainStation;
import com.med.accountservice.stationsManagement.repository.TrainStationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class TrainStationService {
    private TrainStationRepo trainStationRepo ;
    public TrainStation addTrainStation(TrainStation trainStation) {
        return trainStationRepo.save(trainStation) ;
    }
    public List<TrainStation> getAllTrainStations() {
        return trainStationRepo.findAll() ;
    }
}
