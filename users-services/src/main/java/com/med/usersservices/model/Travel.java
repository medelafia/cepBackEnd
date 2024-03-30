package com.med.usersservices.model;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
public class Travel extends Offer{
    private int nbPlaces ;
    private Date date ;
    private Instant beginTime ;
    private Instant arrivedTime ;
    private double distance ;
}
