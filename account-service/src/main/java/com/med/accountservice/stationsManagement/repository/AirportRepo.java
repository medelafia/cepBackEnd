package com.med.accountservice.stationsManagement.repository;

import com.med.accountservice.stationsManagement.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepo extends JpaRepository<Airport,Integer> {
}
