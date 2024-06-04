package com.med.reservationservice.repository;

import com.med.reservationservice.entity.FlightReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightReservationRepo extends JpaRepository<FlightReservation , Integer> {
}
