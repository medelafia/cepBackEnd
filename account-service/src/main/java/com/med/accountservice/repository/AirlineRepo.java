package com.med.accountservice.repository;


import com.med.accountservice.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepo extends JpaRepository<Airline, Integer > {
}
