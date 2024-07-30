package com.med.accountservice.offersManagement.service;


import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.offersManagement.entity.TrainTravel;
import com.med.accountservice.offersManagement.repository.TrainTravelRepo;
import com.med.accountservice.stationsManagement.entity.TrainStation;
import com.med.accountservice.stationsManagement.repository.TrainStationRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TrainTravelService {
    @Autowired
    private TrainTravelRepo trainTravelRepo ;
    @Autowired
    private TrainStationRepo trainStationRepo ;
    public List<TrainTravel> getAllTrainTravels() {
        return trainTravelRepo.findAll();
    }

    public TrainTravel getTrainTravelById(int id) {
        if(trainTravelRepo.findById(id).isPresent()) {
            return trainTravelRepo.findById(id).get() ;
        }else {
            throw new NoElementException("the train travel not found") ;
        }
    }
    public List<TrainTravel> getOneWayTrainTravels(int startId , int endId , Date depart ) {
        return trainTravelRepo.findAllByFromAndToAndDepartureDate(trainStationRepo.findById(startId).get() ,
                trainStationRepo.findById(endId).get() ,
                depart ) ;
    }
    public List<TrainTravel> getRoundTrainTravels(int startId , int endId , Date depart , Date returnDate) {
        return trainTravelRepo.findAllByFromAndToAndDepartureDateAndReturnDate(trainStationRepo.findById(startId).get() ,
                trainStationRepo.findById(endId).get() ,
                depart  ,
                returnDate ) ;
    }
}
