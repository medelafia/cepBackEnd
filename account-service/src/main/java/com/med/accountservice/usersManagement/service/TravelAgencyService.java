package com.med.accountservice.usersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.imagesManagement.service.ImageService;
import com.med.accountservice.offersManagement.entity.OrganizedTravel;
import com.med.accountservice.offersManagement.repository.OrganizedTravelRepo;
import com.med.accountservice.stationsManagement.repository.AirportRepo;
import com.med.accountservice.usersManagement.entity.TravelAgency;
import com.med.accountservice.usersManagement.repository.TravelAgencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelAgencyService{
    @Autowired
    private TravelAgencyRepo travelAgencyRepo ;
    @Autowired
    private OrganizedTravelRepo organizedTravelRepo ;
    @Autowired
    private AirportRepo airportRepo ;
    @Autowired
    private ImageService imageService ;
    public TravelAgency getAuthenticated() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return travelAgencyRepo.findByUsername(username) ;
    }
    public List<OrganizedTravel> addNewOrganizedTravel(MultipartFile cover , OrganizedTravel organizedTravel) {
        TravelAgency travelAgency = this.getAuthenticated()  ;
        organizedTravel.setCover(imageService.updloadImage(cover));
        organizedTravel.setTravelAgency(travelAgency);
        travelAgency.createNewOrganizedTravel(organizedTravelRepo.save(organizedTravel)) ;
        travelAgency = travelAgencyRepo.save(travelAgency) ;
        return travelAgency.getTravels() ;
    }
    public List<OrganizedTravel> getAllOrganizedTravels() {
        return this.getAuthenticated().getTravels() ;
    }

    public void deleteOrganizedTravel(int travelId) {
        TravelAgency travelAgency = this.getAuthenticated() ;
        if(organizedTravelRepo.findById(travelId).isPresent()) {
            OrganizedTravel organizedTravel = organizedTravelRepo.findById(travelId).get() ;
            if(travelAgency.getTravels().contains(organizedTravel)){
                travelAgency.setTravels(travelAgency.getTravels().stream().filter(travel -> travel.getId() != travelId).collect(Collectors.toList()));
                travelAgencyRepo.save(travelAgency)  ;
                organizedTravelRepo.deleteById(travelId);
            }else {
                throw new NoElementException("your travel agency doesn't have this travel") ;
            }
        }
    }
}
