package com.med.reservationservice.web;

import com.med.reservationservice.service.OrganizedTravelReservationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organizedTravel")
@AllArgsConstructor @NoArgsConstructor
public class OrganizedTravelController {
    private OrganizedTravelReservationService organizedTravelReservationService ;
}
