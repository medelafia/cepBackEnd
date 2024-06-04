package com.med.reservationservice.web;

import com.med.reservationservice.entity.Reservation;
import com.med.reservationservice.service.ReservationService;
import jakarta.ws.rs.Path;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/reservations")
public class ReservationController {
    private ReservationService reservationService ;
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService ;
    }
    @PostMapping("/cancel/{id}")
    public Reservation cancelReservation(@PathVariable int id) {
        return reservationService.cancelReservation(id) ;
    }
    @PostMapping("/confirm")
    public Reservation confirmReservation(@PathVariable int id) {
        return reservationService.confirmReservation(id) ;
    }
    @PostMapping("/pay/{id}")
    public Reservation payReservation(@PathVariable int id) {
        return reservationService.payReservation(id);
    }
}
