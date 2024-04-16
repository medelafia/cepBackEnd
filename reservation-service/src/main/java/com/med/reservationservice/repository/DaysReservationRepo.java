package com.med.reservationservice.repository;

import com.med.reservationservice.entity.DaysReservation;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DaysReservationRepo extends JpaRepository<DaysReservation, Integer> {
    public List<DaysReservation> findAllByClientId(int id) ;
}
