package com.med.accountservice.offersManagement.entity;


import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Date;
import java.sql.Time;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@SuperBuilder
public class Travel extends Offer {
    private String origin ;
    private String destination ;
    //
    private int distance ;
    private int nbOfPlaces ;
    private int nbOfStops ;
    private int reservedPlaces ;
    private int travelDuration ;
    //departure info
    private Date departureDate ;
    private Time departureTime ;
    //arrived info
    private Time arrivedTime ;
    //return info
    private Date returnDate ;
    public int incrementReservedPlaces(int count) {
        if(getReservedPlaces() + count > getNbOfPlaces()) {
            this.setReservedPlaces(this.getReservedPlaces() + count) ;
            return nbOfPlaces ;
        }
        return -1 ;
    }
    public int decrementReservedPlaces(int count) {
        if(this.getReservedPlaces() - count < 0 ) {
            this.setReservedPlaces(this.getReservedPlaces() - count) ;
            return nbOfPlaces ;
        }
        return -1 ;
    }
}
