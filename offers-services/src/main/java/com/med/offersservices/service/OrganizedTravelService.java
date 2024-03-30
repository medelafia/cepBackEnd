package com.med.offersservices.service;

import com.med.offersservices.entity.OrganizedTravel;
import com.med.offersservices.repositry.OrganizedTravelRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizedTravelService {
    OrganizedTravelRepo organizedTravelRepo ;
    public OrganizedTravelService(OrganizedTravelRepo organizedTravelRepo) {
        this.organizedTravelRepo = organizedTravelRepo ;
    }
    public OrganizedTravel addNewOrganizedTravel(OrganizedTravel organizedTravel) {
        return organizedTravelRepo.save(organizedTravel) ;
    }
    public List<OrganizedTravel> getOrganizedTravelsByIds(List<Integer> ids){
        return organizedTravelRepo.findAllById(ids) ;
    }
    public void deleteOrganizedTravelById(int id)  {
        organizedTravelRepo.deleteById(id);
    }
}
