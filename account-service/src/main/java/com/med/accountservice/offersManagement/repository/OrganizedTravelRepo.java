package com.med.accountservice.offersManagement.repository;

import com.med.accountservice.offersManagement.entity.OrganizedTravel;
import com.med.accountservice.offersManagement.entity.TrainTravel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface OrganizedTravelRepo extends JpaRepository<OrganizedTravel , Integer> {
    public List<OrganizedTravel> findAllByDestinationAndOriginAndDepartureDate(String origin , String destination , Date date) ;
}
