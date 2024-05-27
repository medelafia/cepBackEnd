package com.med.accountservice.offersManagement.repository;

import com.med.accountservice.offersManagement.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepo extends JpaRepository<Flight , Integer> {
}
