package com.med.reservationservice.repository;

import com.med.reservationservice.entity.CarReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarReservationRepo extends JpaRepository<CarReservation , Integer > {
}
