package com.med.accountservice.offersManagement.service;

import com.med.accountservice.offersManagement.entity.OrganizedTravel;
import com.med.accountservice.offersManagement.repository.OrganizedTravelRepo;
import com.netflix.discovery.converters.Auto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizedTravelsService {
    @Autowired
    private OrganizedTravelRepo organizedTravelRepo ;

    public List<OrganizedTravel> getAllOrganizedTravels() {
        return organizedTravelRepo.findAll() ;
    }
}
