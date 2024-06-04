package com.med.reservationservice.service;

import com.med.reservationservice.repository.TrainTravelReservationRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service @AllArgsConstructor @NoArgsConstructor
public class TrainTravelReservationService {
    private TrainTravelReservationRepo trainTravelRepo;
}
