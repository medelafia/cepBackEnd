package com.med.destinationservice.repository;

import com.med.destinationservice.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationRepo extends JpaRepository<Destination , Integer> {
    public List<Destination> findAllByCountry(String country) ;
}
