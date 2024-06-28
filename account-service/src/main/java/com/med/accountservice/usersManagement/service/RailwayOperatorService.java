package com.med.accountservice.usersManagement.service;


import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.offersManagement.entity.TrainTravel;
import com.med.accountservice.offersManagement.repository.TrainTravelRepo;
import com.med.accountservice.stationsManagement.repository.TrainStationRepo;
import com.med.accountservice.usersManagement.entity.RailwayOperator;
import com.med.accountservice.usersManagement.repository.RailwayOperatorRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RailwayOperatorService {
    @Autowired
    private RailwayOperatorRepo railwayOperatorRepo ;
    @Autowired
    private TrainTravelRepo trainTravelRepo ;
    @Autowired
    TrainStationRepo trainStationRepo ;
    public List<TrainTravel> addNewTrainTravel(int providerId , TrainTravel trainTravel) {
        if(railwayOperatorRepo.findById(providerId).isPresent()) {
            RailwayOperator railwayOperator = railwayOperatorRepo.findById(providerId).get() ;
            trainTravel.setFrom(trainStationRepo.findById(trainTravel.getFrom().getId()).get());
            trainTravel.setTo(trainStationRepo.findById(trainTravel.getTo().getId()).get());
            railwayOperator.createNewTrainTravel(trainTravelRepo.save(trainTravel)) ;
            railwayOperator = railwayOperatorRepo.save(railwayOperator) ;
            return railwayOperator.getTravelList() ;
        }else {
            throw new NoElementException("the railway not found");
        }
    }
    public List<TrainTravel> getAllTrainTravelsByRwO(int id) {
        if(railwayOperatorRepo.findById(id).isPresent()) {
            RailwayOperator railwayOperator = railwayOperatorRepo.findById(id).get() ;
            return railwayOperator.getTravelList() ;
        }else {
            throw new NoElementException("the railway operator not found") ;
        }
    }
}
