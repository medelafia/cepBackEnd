package com.med.reservationservice.service;

import com.med.reservationservice.entity.*;
import com.med.reservationservice.enums.ReservationStatus;
import com.med.reservationservice.repository.*;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepo reservationRepo;
    @Autowired
    private TrainTravelReservationRepo trainTravelReservationRepo ;
    @Autowired
    private FlightReservationRepo flightReservationRepo ;
    @Autowired
    private RoomReservationRepo roomReservationRepo ;
    @Autowired
    private OrganizedTravelReservationRepo organizedTravelReservationRepo;
    @Autowired
    private CarReservationRepo carReservationRepo  ;
    @Autowired
    private PaymentService paymentService ;
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

    public Reservation createReservation(CarReservation carReservation) {
        try {
            String paymentLink = paymentService.createPaymentLink(carReservation) ;
            carReservation.setPaymentLink(paymentLink);
            return carReservationRepo.save(carReservation) ;
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }
    }
    public Reservation createReservation(TrainTravelReservation trainTravelReservation) {
        try {
            String paymentLink = paymentService.createPaymentLink(trainTravelReservation) ;
            trainTravelReservation.setPaymentLink(paymentLink);
            return trainTravelReservationRepo.save(trainTravelReservation) ;
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }
    }
    public Reservation createReservation(FlightReservation flightReservation) {
        try {
            String paymentLink = paymentService.createPaymentLink(flightReservation) ;
            flightReservation.setPaymentLink(paymentLink) ;
            return flightReservationRepo.save(flightReservation) ;
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }
    }
    public Reservation createReservation(OrganizedTravelReservation organizedTravelReservation) {
        try {
            String paymentLink = paymentService.createPaymentLink(organizedTravelReservation) ;
            organizedTravelReservation.setPaymentLink(paymentLink) ;
            return organizedTravelReservationRepo.save(organizedTravelReservation) ;
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }
    }
    public Reservation createReservation(RoomReservation reservation) {
        try {
            String paymentLink = paymentService.createPaymentLink(reservation) ;
            System.out.println(paymentLink);
            reservation.setPaymentLink(paymentLink);
            return roomReservationRepo.save(reservation) ;
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }
    }
}
