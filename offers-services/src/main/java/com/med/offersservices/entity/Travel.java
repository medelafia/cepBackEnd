package com.med.offersservices.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.Date;

@MappedSuperclass
@AllArgsConstructor @NoArgsConstructor @SuperBuilder
@Setter @Getter
public class Travel extends Offer{
    private int nbPlaces ;
    private Date date ;
    private Instant beginTime ;
    private Instant arrivedTime ;
    private double distance ;
}
