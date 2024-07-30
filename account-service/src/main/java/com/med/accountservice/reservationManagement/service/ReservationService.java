package com.med.accountservice.reservationManagement.service;

import com.med.accountservice.reservationManagement.entity.*;
import com.med.accountservice.reservationManagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    ReservationRepo reservationRepo ;

    public Reservation reservation(Reservation reservation) {
        return new Reservation() ;
    }
}
