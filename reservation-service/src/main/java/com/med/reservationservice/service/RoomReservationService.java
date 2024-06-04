package com.med.reservationservice.service;

import com.med.reservationservice.repository.RoomReservationRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class RoomReservationService {
    private RoomReservationRepo roomReservationRepo ;

}
