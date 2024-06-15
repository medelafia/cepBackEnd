package com.med.accountservice.stationsManagement.repository;

import com.med.accountservice.stationsManagement.entity.Gate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GateRepo extends JpaRepository<Gate , String > {
}
