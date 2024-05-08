package com.med.accountservice.repository;


import com.med.accountservice.entity.CarsAgency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsAgencyRepo extends JpaRepository<CarsAgency, Integer> {
}
