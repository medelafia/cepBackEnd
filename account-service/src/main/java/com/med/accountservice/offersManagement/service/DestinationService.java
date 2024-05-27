package com.med.accountservice.offersManagement.service;


import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.offersManagement.entity.Destination;
import com.med.accountservice.offersManagement.repository.DestinationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DestinationService {
    private DestinationRepo destinationRepo ;
    public Destination getDestinationById(int id) {
        return destinationRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("destination not found") ;
        });
    }
    public Destination addDestination(Destination destination) {
        return destinationRepo.save(destination) ;
    }
    public void deleteDestination(int id) {
        destinationRepo.deleteById(id);
    }

}
