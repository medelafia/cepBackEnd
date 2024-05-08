package com.med.accountservice.service;

import com.med.usersservices.entity.CarsAgency;
import com.med.usersservices.feignRepo.OffersRepo;
import com.med.usersservices.repository.CarsAgencyRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarAgencyService {
    CarsAgencyRepo carsAgencyRepo ;
    OffersRepo offersRepo ;

    public CarAgencyService(CarsAgencyRepo carsAgencyRepo, OffersRepo offersRepo) {
        this.carsAgencyRepo = carsAgencyRepo;
        this.offersRepo = offersRepo;
    }
    public CarsAgency registerNewCarsAgency( CarsAgency carsAgency ) {
        return carsAgencyRepo.save(carsAgency) ;
    }
    public List<CarsAgency> getAllCarsAgencies() {
        List<CarsAgency> carsAgencies = carsAgencyRepo.findAll() ;
        carsAgencies.forEach(carsAgency -> {
            carsAgency.setCars(offersRepo.getAllCarsByAgencyId(carsAgency.getId()));
        });
        return carsAgencies ;
    }
}
