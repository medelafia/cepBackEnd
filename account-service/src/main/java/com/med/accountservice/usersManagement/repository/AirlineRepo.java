package com.med.accountservice.usersManagement.repository;

import com.med.accountservice.usersManagement.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepo extends JpaRepository<Airline, Integer> {
}
