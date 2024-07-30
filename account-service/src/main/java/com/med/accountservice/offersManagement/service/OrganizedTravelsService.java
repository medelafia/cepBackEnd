package com.med.accountservice.offersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.offersManagement.entity.OrganizedTravel;
import com.med.accountservice.offersManagement.repository.OrganizedTravelRepo;
import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizedTravelsService {
    @Autowired
    private OrganizedTravelRepo organizedTravelRepo ;

    public List<OrganizedTravel> getAllOrganizedTravels(String origin , String destination, Date date) {
        if(destination != null && date != null ) {
            return organizedTravelRepo.findAllByDestinationAndOriginAndDepartureDate(origin , destination , date )
                    .stream().map(organizedTravel -> {
                        organizedTravel.setProvider(ProviderMapper.toProviderResponse(organizedTravel.getTravelAgency()));
                        return organizedTravel ;
                    }).collect(Collectors.toList());
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
