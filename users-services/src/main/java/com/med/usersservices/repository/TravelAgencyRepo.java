package com.med.usersservices.repository;

import com.med.usersservices.entity.TravelAgency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelAgencyRepo extends JpaRepository<TravelAgency, Integer> {
}
