package com.med.accountservice.offersManagement.repository;

import com.med.accountservice.offersManagement.entity.TrainTravel;
import com.med.accountservice.stationsManagement.entity.TrainStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface TrainTravelRepo extends JpaRepository<TrainTravel , Integer> {
    public List<TrainTravel> findAllByFromAndToAndDepartureDate(TrainStation from, TrainStation to , Date departure) ;
    public List<TrainTravel> findAllByFromAndToAndDepartureDateAndReturnDate(TrainStation from , TrainStation to , Date departure , Date returnDate  ) ;
}
