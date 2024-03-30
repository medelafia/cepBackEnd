package com.med.offersservices.service;

import com.med.offersservices.entity.TrainTravel;
import com.med.offersservices.repositry.TrainTravelRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainTravelService {
    TrainTravelRepo trainTravelRepo ;

    public TrainTravelService(TrainTravelRepo trainTravelRepo) {
        this.trainTravelRepo = trainTravelRepo;
    }
    public List<TrainTravel> getTrainTravelsByIds(List<Integer> ids) {
        return trainTravelRepo.findAllById(ids);
    }
    public TrainTravel addNewTrainTravel(TrainTravel trainTravel) {
        return trainTravelRepo.save(trainTravel) ;
    }
    public void deleteTrainTravelById(int id) {
        trainTravelRepo.deleteById(id);
    }
}
