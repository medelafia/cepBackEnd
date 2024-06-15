package com.med.accountservice.offersManagement.service;


import com.med.accountservice.offersManagement.entity.TrainTravel;
import com.med.accountservice.offersManagement.repository.TrainTravelRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainTravelService {
    @Autowired
    private TrainTravelRepo trainTravelRepo ;
    public List<TrainTravel> getAllTrainTravels() {
        return trainTravelRepo.findAll();
    }
}
