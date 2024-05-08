package com.med.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
