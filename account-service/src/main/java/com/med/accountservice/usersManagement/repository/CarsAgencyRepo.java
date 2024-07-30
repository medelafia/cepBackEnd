package com.med.accountservice.usersManagement.repository;

import com.med.accountservice.usersManagement.entity.CarsAgency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarsAgencyRepo extends JpaRepository<CarsAgency , Integer> {
    public Optional<CarsAgency> findByUsername(String username) ;
}
