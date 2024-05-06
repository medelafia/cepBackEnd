package com.med.gateservice.service;

import com.med.gateservice.dto.TrainStationDto;
import com.med.gateservice.entity.TrainStation;
import com.med.gateservice.mapper.TrainStationMapper;
import com.med.gateservice.repositry.TrainStationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainStationService {
    TrainStationRepo trainStationRepo ;
    public TrainStationService(TrainStationRepo trainStationRepo) {
        this.trainStationRepo = trainStationRepo ;
    }
    public TrainStation getTrainStationById(int id) {
        return trainStationRepo.findById(id).orElseThrow();
    }
    public List<TrainStation> getAllTrainStations() {
        return trainStationRepo.findAll() ;
    }
    public TrainStation addTrainStation(TrainStationDto trainStationDto) {
        return trainStationRepo.save(TrainStationMapper.toTrainStation(trainStationDto )) ;
    }
}
