package com.med.reservationservice.service;

import com.med.reservationservice.entity.DaysReservation;
import com.med.reservationservice.repository.DaysReservationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaysReservationService {
    DaysReservationRepo daysReservationRepo ;
    public DaysReservationService(DaysReservationRepo daysReservationRepo ) {
        this.daysReservationRepo = daysReservationRepo ;
    }
    public DaysReservation createNewReservation(DaysReservation daysReservation) {
        return daysReservationRepo.save(daysReservation) ;
    }
    public List<DaysReservation> getAllReservationsByClientsId(int clientId) {
        return daysReservationRepo.findAllByClientId(clientId);
    }
}
