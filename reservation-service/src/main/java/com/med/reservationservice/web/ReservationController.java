package com.med.reservationservice.web;

import com.med.reservationservice.entity.*;
import com.med.reservationservice.service.ReservationService;
import jakarta.ws.rs.Path;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService ;
    @PostMapping("/car/create")
    public Reservation createCarReservation(@RequestBody CarReservation carReservation){
        return reservationService.createReservation(carReservation) ;
    }
    @PostMapping("/trainTravel/create")
    public Reservation createTrainTravelReservation(@RequestBody TrainTravelReservation trainTravelReservation) {
        return reservationService.createReservation(trainTravelReservation) ;
    }
    @PostMapping("/room/create")
    public Reservation createRoomReservation(@RequestBody RoomReservation roomReservation) {
        return reservationService.createReservation(roomReservation) ;
    }
    @PostMapping("/organizedTravel/create")
    public Reservation createOrganizedTravelReservation(@RequestBody OrganizedTravelReservation organizedTravelReservation) {
        return reservationService.createReservation(organizedTravelReservation) ;
    }
    @PostMapping("/flight/create")
    public Reservation createFlightReservation(@RequestBody FlightReservation flightReservation) {
        return reservationService.createReservation(flightReservation) ;
    }
    @PostMapping("/cancel/{id}")
    public Reservation cancelReservation(@PathVariable int id) {
        return reservationService.cancelReservation(id) ;
    }
    @PostMapping("/confirm/{id}")
    public Reservation confirmReservation(@PathVariable int id) {
        return reservationService.confirmReservation(id) ;
    }
    @PostMapping("/pay/{id}")
    public Reservation payReservation(@PathVariable int id) {
        return reservationService.payReservation(id);
    }

}
