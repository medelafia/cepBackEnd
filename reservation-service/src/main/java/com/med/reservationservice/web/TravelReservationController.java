package com.med.reservationservice.web;

import com.med.reservationservice.service.TravelReservationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/travelReservation")
public class TravelReservationController {
    TravelReservationService travelReservationService ;
    public TravelReservationController(TravelReservationService travelReservationService) {
        this.travelReservationService = travelReservationService ;
    }
}
