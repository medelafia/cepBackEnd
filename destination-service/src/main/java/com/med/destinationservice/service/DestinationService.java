package com.med.destinationservice.service;

import com.med.destinationservice.entity.Destination;
import com.med.destinationservice.repository.DestinationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {
    DestinationRepo destinationRepo ;
    public DestinationService(DestinationRepo destinationRepo) {
        this.destinationRepo = destinationRepo ;
    }
    public Destination addNewDestination(Destination destination) {
        return destinationRepo.save(destination) ;
    }
    public List<Destination> getAllDestinations() {
        return destinationRepo.findAll() ;
    }
    public List<Destination> getAllDestinationsByCountry(String country) {
        return destinationRepo.findAllByCountry(country) ;
    }
}
