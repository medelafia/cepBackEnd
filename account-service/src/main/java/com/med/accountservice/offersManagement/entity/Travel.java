package com.med.accountservice.offersManagement.entity;

import com.med.accountservice.enums.FlightType;
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
    private int distance ;
    private Date date ;
    private Time startTime ;
    private Time endTime ;
    private int nbOfPlaces ;
    private int nbOfStops ;
}
