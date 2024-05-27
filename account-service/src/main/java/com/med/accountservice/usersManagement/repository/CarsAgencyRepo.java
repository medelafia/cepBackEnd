package com.med.accountservice.usersManagement.repository;

import com.med.accountservice.usersManagement.entity.CarsAgency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsAgencyRepo extends JpaRepository<CarsAgency , Integer> {
}
