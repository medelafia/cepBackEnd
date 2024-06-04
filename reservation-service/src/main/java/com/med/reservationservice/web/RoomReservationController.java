package com.med.reservationservice.web;

import com.med.reservationservice.service.RoomReservationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
@AllArgsConstructor @NoArgsConstructor
public class RoomReservationController {
    private RoomReservationService roomReservationService ;
}
