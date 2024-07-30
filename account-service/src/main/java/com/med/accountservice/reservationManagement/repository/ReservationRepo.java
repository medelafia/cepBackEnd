package com.med.accountservice.reservationManagement.repository;

import com.med.accountservice.reservationManagement.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation, Integer> {
}
