package com.med.gateservice.repositry;

import com.med.gateservice.entity.TrainStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainStationRepo extends JpaRepository<TrainStation , Integer> {
}
