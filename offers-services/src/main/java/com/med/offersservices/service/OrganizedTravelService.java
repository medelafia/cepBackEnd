package com.med.offersservices.service;

import com.med.offersservices.entity.Flight;
import com.med.offersservices.entity.OrganizedTravel;
import com.med.offersservices.feignClient.GateRepo;
import com.med.offersservices.repositry.OrganizedTravelRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizedTravelService {
    OrganizedTravelRepo organizedTravelRepo ;
    GateRepo gateRepo ;
    public OrganizedTravelService(OrganizedTravelRepo organizedTravelRepo , GateRepo gateRepo) {
        this.organizedTravelRepo = organizedTravelRepo ;
        this.gateRepo = gateRepo ;
    }
    public OrganizedTravel addNewOrganizedTravel(OrganizedTravel organizedTravel) {
        return organizedTravelRepo.save(organizedTravel) ;
    }
    public List<OrganizedTravel> getOrganizedTravelsByTravelAgencyId(int id) {
        List<OrganizedTravel> organizedTravels = organizedTravelRepo.findAllByTravelAgencyId(id) ;
        organizedTravels.forEach(organizedTravel -> {
            organizedTravel.setStartAirport(gateRepo.getAirportById(organizedTravel.getStartAirportId()));
        });
        return organizedTravels ;
    }
    public void deleteOrganizedTravelById(int id)  {
        organizedTravelRepo.deleteById(id);
    }
    public List<OrganizedTravel> getAllOrganizedTravels() {
        return organizedTravelRepo.findAll() ;
    }
}
