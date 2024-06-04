package com.med.reservationservice.web;

import com.med.reservationservice.entity.CarReservation;
import com.med.reservationservice.service.CarReservationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carReservation")
@AllArgsConstructor
@NoArgsConstructor
public class CarReservationController {
    private CarReservationService carReservationService ;
    @PostMapping("/")
    public CarReservation createReservation(@RequestBody CarReservation carReservation) {
        return carReservationService.createReservation(carReservation) ;
    }
}
