package com.med.reservationservice.service;

import com.med.reservationservice.repository.FlightReservationRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor @NoArgsConstructor
public class FlightReservationService {
    private FlightReservationRepo flightReservationRepo ;
}
