package com.med.usersservices.repository;

import com.med.usersservices.entity.CarsAgency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsAgencyRepo extends JpaRepository<CarsAgency , Integer> {
}
