package com.med.reservationservice.service;

import com.med.reservationservice.entity.TravelReservation;
import com.med.reservationservice.repository.TravelReservationRepo;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelReservationService {
    TravelReservationRepo travelReservationRepo ;
    public TravelReservationService(TravelReservationRepo travelReservationRepo) {
        this.travelReservationRepo = travelReservationRepo ;
    }
    public TravelReservation createNewReservation(TravelReservation travelReservation) {
        return travelReservationRepo.save(travelReservation) ;
    }
    public List<TravelReservation> findAllReservationByClientId(int clientId) {
        return travelReservationRepo.findAllByClientId(clientId) ;
    }

}
