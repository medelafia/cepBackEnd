package com.med.reservationservice.repository;

import com.med.reservationservice.entity.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomReservationRepo extends JpaRepository<RoomReservation , Integer> {
}
