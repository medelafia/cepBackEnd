package com.med.accountservice.usersManagement.service;


import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.offersManagement.entity.TrainTravel;
import com.med.accountservice.offersManagement.entity.TravelClass;
import com.med.accountservice.offersManagement.repository.TrainTravelRepo;
import com.med.accountservice.offersManagement.repository.TravelClassRepo;
import com.med.accountservice.stationsManagement.repository.TrainStationRepo;
import com.med.accountservice.usersManagement.entity.RailwayOperator;
import com.med.accountservice.usersManagement.repository.RailwayOperatorRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RailwayOperatorService {
    @Autowired
    private RailwayOperatorRepo railwayOperatorRepo ;
    @Autowired
    private TrainTravelRepo trainTravelRepo ;
    @Autowired
    TrainStationRepo trainStationRepo ;
    @Autowired
    TravelClassRepo travelClassRepo ;
    public RailwayOperator getAuthenticated() {
        return railwayOperatorRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get() ;
    }
    public List<TrainTravel> addNewTrainTravel(TrainTravel trainTravel) {
        RailwayOperator railwayOperator = this.getAuthenticated() ;
        trainTravel.setFrom(trainStationRepo.findById(trainTravel.getFrom().getId()).get());
        trainTravel.setTo(trainStationRepo.findById(trainTravel.getTo().getId()).get());
        trainTravel.setRailwayOperator(railwayOperator);
        List<TravelClass> travelClasses = new ArrayList<>() ;
        trainTravel.getTrainTravelClasses().forEach(travelClass ->  {
            travelClasses.add(travelClassRepo.save(travelClass));
        });
        trainTravel.setTrainTravelClasses(travelClasses);
        railwayOperator.createNewTrainTravel(trainTravelRepo.save(trainTravel)) ;
        railwayOperator = railwayOperatorRepo.save(railwayOperator) ;
        return railwayOperator.getTravelList() ;
    }
    public List<TrainTravel> getAllTrainTravels() {
        return this.getAuthenticated().getTravelList() ;
    }
    public void deleteTrainTravel(int trainTravelId , TrainTravel newData) {
        RailwayOperator railwayOperator = this.getAuthenticated() ;
        if(trainTravelRepo.findById(trainTravelId).isPresent()) {
            TrainTravel trainTravel = trainTravelRepo.findById(trainTravelId).get() ;
            if(railwayOperator.getTravelList().contains(trainTravel) ) {
                trainTravelRepo.deleteById(trainTravelId);
            }else {
                throw new NoElementException("the train travel not find") ;
            }
        }else {
            throw new NoElementException("the train travel not exist") ;
        }
    }
}
