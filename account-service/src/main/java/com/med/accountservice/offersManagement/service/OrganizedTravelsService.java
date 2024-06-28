package com.med.accountservice.offersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.offersManagement.entity.OrganizedTravel;
import com.med.accountservice.offersManagement.repository.OrganizedTravelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class OrganizedTravelsService {
    @Autowired
    private OrganizedTravelRepo organizedTravelRepo ;

    public List<OrganizedTravel> getAllOrganizedTravels(String destination, Date date) {
        if(destination != null && date != null ) {
            return organizedTravelRepo.findAllByDestinationAndDepartureDate(destination , date );
        }else {
            return organizedTravelRepo.findAll() ;
        }
    }
    public OrganizedTravel getOrganizedTravelById(int id) {
        if(organizedTravelRepo.findById(id).isPresent()) {
            return organizedTravelRepo.findById( id).get() ;
        }else {
            throw new NoElementException("the organized travel not found");
        }
    }
}
