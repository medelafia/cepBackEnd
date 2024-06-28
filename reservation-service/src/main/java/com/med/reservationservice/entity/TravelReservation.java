package com.med.reservationservice.entity;


import com.med.reservationservice.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Time;
import java.util.Date;

@MappedSuperclass
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class TravelReservation extends Reservation{
    private int nbPersons ;
    private int nbChildrens ;
    private long totalPrice ;
    private int seatNumber;
    private SeatType seatType ;
}
