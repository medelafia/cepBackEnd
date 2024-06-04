package com.med.reservationservice.service;

import com.med.reservationservice.entity.CarReservation;
import com.med.reservationservice.repository.CarReservationRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service @AllArgsConstructor @NoArgsConstructor
public class CarReservationService {
    private CarReservationRepo carReservationRepo ;
    public CarReservation createReservation(CarReservation carReservation) {
        return carReservationRepo.save(carReservation) ;
    }
}