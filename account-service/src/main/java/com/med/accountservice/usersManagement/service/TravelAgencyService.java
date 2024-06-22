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
import java.util.stream.Collectors;

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

    public void deleteOrganizedTravel(int id, int travelId) {
        if(travelAgencyRepo.findById(id).isPresent()) {
            TravelAgency travelAgency = travelAgencyRepo.findById(id).get() ;
            if(organizedTravelRepo.findById(travelId).isPresent()) {
                OrganizedTravel organizedTravel = organizedTravelRepo.findById(travelId).get() ;
                if(travelAgency.getTravels().contains(organizedTravel)){
                    travelAgency.setTravels(travelAgency.getTravels().stream().filter(travel -> travel.getId() != travelId).collect(Collectors.toList()));
                    travelAgencyRepo.save(travelAgency)  ;
                    organizedTravelRepo.deleteById(travelId);
                }else {
                    throw new NoElementException("your travel agency doesn't have this travel") ;
                }
            }else {
                throw new NoElementException("the travel not found") ;
            }
        }else {
            throw new NoElementException("the travel agency not found") ;
        }
    }
}
