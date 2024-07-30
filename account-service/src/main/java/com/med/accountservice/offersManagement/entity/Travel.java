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
    //
    private int distance ;
    private int nbOfStops ;
    private Time travelDuration ;
    //departure info
    private Date departureDate ;
    private Time departureTime ;
    //arrived info
    private Time arrivedTime ;
    //return info
    private Date returnDate ;
}
