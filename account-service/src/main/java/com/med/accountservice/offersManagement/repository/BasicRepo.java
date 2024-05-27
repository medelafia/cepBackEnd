package com.med.accountservice.offersManagement.repository;

import com.med.accountservice.offersManagement.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicRepo extends JpaRepository<Offer , Integer> {
}
