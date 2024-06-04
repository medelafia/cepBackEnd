package com.med.reservationservice.repository;

import com.med.reservationservice.entity.OrganizedTravelReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizedTravelReservationRepo extends JpaRepository<OrganizedTravelReservation , Integer > {
}
