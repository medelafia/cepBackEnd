package com.med.reservationservice.service;

import com.med.reservationservice.entity.Reservation;
import com.med.reservationservice.enums.ReservationStatus;
import com.med.reservationservice.repository.ReservationRepo;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private ReservationRepo reservationRepo;
    public ReservationService(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo ;
    }
    public Reservation cancelReservation(int id) {
        Reservation reservation = reservationRepo.findById(id).get();
        reservation.setReservationStatus(ReservationStatus.CANCELED) ;
        return reservationRepo.save(reservation) ;
    }
    public Reservation confirmReservation(int id) {
        Reservation reservation = reservationRepo.findById(id).get() ;
        reservation.setReservationStatus(ReservationStatus.VERIFIED);
        return reservationRepo.save(reservation) ;
    }
    public Reservation payReservation(int id) {
        Reservation reservation = reservationRepo.findById(id).get() ;
        reservation.setPaid(true) ;
        return reservationRepo.save(reservation) ;
    }
}
