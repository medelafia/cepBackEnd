package com.med.accountservice.usersManagement.repository;

import com.med.accountservice.usersManagement.entity.TravelAgency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelAgencyRepo extends JpaRepository<TravelAgency , Integer> {
}
