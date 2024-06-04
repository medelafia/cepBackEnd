package com.med.reservationservice.service;

import com.med.reservationservice.repository.OrganizedTravelReservationRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor @NoArgsConstructor
public class OrganizedTravelReservationService {
    private OrganizedTravelReservationRepo organizedTravelReservationRepo ;
}
