package com.med.accountservice.offersManagement.repository;

import com.med.accountservice.offersManagement.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepo extends JpaRepository<Destination , Integer> {
}
