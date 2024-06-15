package com.med.accountservice.stationsManagement.repository;

import com.med.accountservice.stationsManagement.entity.TrainStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainStationRepo extends JpaRepository<TrainStation , String> {
}
