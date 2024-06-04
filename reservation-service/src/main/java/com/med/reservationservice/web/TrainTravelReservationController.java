package com.med.reservationservice.web;

import com.med.reservationservice.service.TrainTravelReservationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor @NoArgsConstructor @RequestMapping("/trainTravel")
public class TrainTravelReservationController {
    private TrainTravelReservationService trainTravelReservationService ;
}
