package com.med.accountservice.offersManagement.repository;

import com.med.accountservice.offersManagement.entity.TravelClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelClassRepo extends JpaRepository<TravelClass , Integer > {
}
