package com.med.reservationservice.entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.util.Date;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class TravelReservation extends Reservation{
    private String travelClass ;
    private int numPlace;
    private Date travelDate ;
    private int hour ;
}