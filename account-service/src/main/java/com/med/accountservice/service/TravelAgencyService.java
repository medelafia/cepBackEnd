package com.med.accountservice.service;

import com.med.usersservices.entity.TravelAgency;
import com.med.usersservices.feignRepo.OffersRepo;
import com.med.usersservices.repository.TravelAgencyRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelAgencyService {
    TravelAgencyRepo travelAgencyRepo ;
    OffersRepo offersRepo ;

    public TravelAgencyService(TravelAgencyRepo travelAgencyRepo, OffersRepo offersRepo) {
        this.travelAgencyRepo = travelAgencyRepo;
        this.offersRepo = offersRepo;
    }
    public TravelAgency registerNewTravelAgency(TravelAgency travelAgency) {
        return travelAgencyRepo.save(travelAgency) ;
    }
    public List<TravelAgency> getAllTravelsAgencies() {
        List<TravelAgency> travelAgencies = travelAgencyRepo.findAll() ;
        travelAgencies.forEach(travelAgency -> {
            travelAgency.setOrganizedTravels(offersRepo.getAllOrganizeTravelsByAgencyId(travelAgency.getId()));
        });
        return travelAgencies ;
    }
}
