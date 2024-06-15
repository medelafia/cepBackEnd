package com.med.accountservice.usersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.offersManagement.entity.OrganizedTravel;
import com.med.accountservice.offersManagement.repository.OrganizedTravelRepo;
import com.med.accountservice.usersManagement.entity.TravelAgency;
import com.med.accountservice.usersManagement.repository.TravelAgencyRepo;
import com.netflix.discovery.converters.Auto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelAgencyService{
    @Autowired
    private TravelAgencyRepo travelAgencyRepo ;
    @Autowired
    private OrganizedTravelRepo organizedTravelRepo ;
    public TravelAgency addNewOrganizedTravel(int providerId ,OrganizedTravel organizedTravel) {
        TravelAgency travelAgency = travelAgencyRepo.findById(providerId).orElseThrow(()->{
            throw new NoElementException("the account not found") ;
        }) ;
        travelAgency.createNewOrganizedTravel(organizedTravelRepo.save(organizedTravel)) ;
        return travelAgencyRepo.save(travelAgency) ;
    }
    public List<OrganizedTravel> getAllOrganizedTravelsByTravelAgency(int id) {
        TravelAgency travelAgency = travelAgencyRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("the travel agency not found") ;
        }) ;
        if( travelAgency != null ) return travelAgency.getTravels() ;
        return null ;
    }
}
