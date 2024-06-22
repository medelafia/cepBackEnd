package com.med.accountservice.offersManagement.repository;

import com.med.accountservice.offersManagement.entity.OrganizedTravel;
import com.med.accountservice.offersManagement.entity.TrainTravel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizedTravelRepo extends JpaRepository<OrganizedTravel , Integer> {
}
