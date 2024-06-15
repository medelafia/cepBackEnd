package com.med.accountservice.usersManagement.service;


import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.offersManagement.entity.TrainTravel;
import com.med.accountservice.offersManagement.repository.TrainTravelRepo;
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
    public RailwayOperator addNewTrainTravel(int providerId , TrainTravel trainTravel) {
        RailwayOperator railwayOperator = railwayOperatorRepo.findById(providerId).orElseThrow(()->{
            throw new NoElementException("the railway operator not found") ;
        }) ;
        railwayOperator.createNewTrainTravel(trainTravelRepo.save(trainTravel) );
        return railwayOperatorRepo.save(railwayOperator);
    }
    public List<TrainTravel> getAllTrainTravelsByRwO(int id) {
        RailwayOperator railwayOperator = railwayOperatorRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("the railway operator not found") ;
        }) ;
        if(railwayOperator != null ) return railwayOperator.getTravelList() ;
        return null ;
    }
}
