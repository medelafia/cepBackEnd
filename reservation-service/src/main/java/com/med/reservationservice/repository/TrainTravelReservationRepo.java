package com.med.reservationservice.repository;

import com.med.reservationservice.entity.TrainTravelReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainTravelReservationRepo extends JpaRepository<TrainTravelReservation , Integer > {
}
