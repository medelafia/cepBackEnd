package com.med.offersservices.service;

import com.med.offersservices.entity.TrainTravel;
import com.med.offersservices.feignClient.GateRepo;
import com.med.offersservices.repositry.TrainTravelRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainTravelService {
    TrainTravelRepo trainTravelRepo ;
    GateRepo gateRepo ;

    public TrainTravelService(TrainTravelRepo trainTravelRepo , GateRepo gateRepo) {
        this.trainTravelRepo = trainTravelRepo;
        this.gateRepo = gateRepo ;
    }
    public List<TrainTravel> getAllByRailWaysOperatorId(int id ){
        List<TrainTravel> trainTravels = trainTravelRepo.findAllByRailWaysOperatorId(id) ;
        trainTravels.forEach(trainTravel -> {
            trainTravel.setStartTrainStation(gateRepo.getTrainStationById(trainTravel.getStartStationId()));
            trainTravel.setArriverTrainStation(gateRepo.getTrainStationById(trainTravel.getArrivedStationId()));
        });
        return trainTravels ;
    }
    public TrainTravel addNewTrainTravel(TrainTravel trainTravel) {
        return trainTravelRepo.save(trainTravel) ;
    }
    public void deleteTrainTravelById(int id) {
        trainTravelRepo.deleteById(id);
    }
    public List<TrainTravel> getAllTrainTravels() {
        return trainTravelRepo.findAll() ;
    }
}
