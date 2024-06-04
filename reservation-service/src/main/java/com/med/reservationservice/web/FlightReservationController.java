package com.med.reservationservice.web;

import com.med.reservationservice.service.FlightReservationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
@AllArgsConstructor @NoArgsConstructor
public class FlightReservationController {
    private FlightReservationService flightReservationService ;
}
