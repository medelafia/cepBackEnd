package com.med.reservationservice.repository;

import com.med.reservationservice.entity.TravelReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelReservationRepo extends JpaRepository<TravelReservation , Integer> {
    public List<TravelReservation> findAllByClientId(int id) ;
}
