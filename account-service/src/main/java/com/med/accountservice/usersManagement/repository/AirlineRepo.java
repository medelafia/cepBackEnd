package com.med.accountservice.usersManagement.repository;

import com.med.accountservice.usersManagement.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirlineRepo extends JpaRepository<Airline, Integer> {
    public Optional<Airline> findByUsername(String username) ;
}
