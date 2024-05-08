package com.med.accountservice.repository;


import com.med.accountservice.entity.TravelAgency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelAgencyRepo extends JpaRepository<TravelAgency, Integer> {
}
