package com.med.offersservices.repositry;

import com.med.offersservices.entity.TrainTravel;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainTravelRepo extends JpaRepository<TrainTravel, Integer> {
    public List<TrainTravel> findAllByRailWaysOperatorId(int id ) ;
}
