package com.med.reservationservice.entity;


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
    private String travelClass ;
    private int numPlace;
    private Date travelDate ;
    private Time travelTime ;
}
