package com.med.accountservice.usersManagement.repository;

import com.med.accountservice.usersManagement.entity.Amenitie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenitieRepo extends JpaRepository<Amenitie , Integer> {
}
