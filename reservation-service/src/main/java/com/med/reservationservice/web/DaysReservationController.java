package com.med.reservationservice.web;


import com.med.reservationservice.service.DaysReservationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daysReservation")
public class DaysReservationController {
    DaysReservationService daysReservationService ;
    public DaysReservationController(DaysReservationService daysReservationService ) {
        this.daysReservationService = daysReservationService ;
    }
}
