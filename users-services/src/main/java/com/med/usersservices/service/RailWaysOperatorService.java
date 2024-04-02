package com.med.usersservices.service;

import com.med.usersservices.entity.RailwayOperator;
import com.med.usersservices.feignRepo.OffersRepo;
import com.med.usersservices.model.Offer;
import com.med.usersservices.repository.RailwaysOperatorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RailWaysOperatorService {
    RailwaysOperatorRepo railwaysOperatorRepo ;
    OffersRepo offersRepo ;
    public RailWaysOperatorService(RailwaysOperatorRepo railwaysOperatorRepo , OffersRepo offersRepo) {
        this.railwaysOperatorRepo = railwaysOperatorRepo ;
        this.offersRepo = offersRepo ;
    }
    public RailwayOperator registerNewRailWay(RailwayOperator railwaysOperator) {
        return railwaysOperatorRepo.save(railwaysOperator) ;
    }
    public List<RailwayOperator> getAllRailWays() {
        List<RailwayOperator> railwayOperators = railwaysOperatorRepo.findAll() ;
        railwayOperators.forEach(railwayOperator -> {
            railwayOperator.setTrainTravels(offersRepo.getAllTrainTravelsByAgencyId(railwayOperator.getId()));
        });
        return railwayOperators ;
    }
}
