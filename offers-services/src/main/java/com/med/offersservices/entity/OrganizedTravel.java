package com.med.offersservices.entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity @NoArgsConstructor @AllArgsConstructor @SuperBuilder
@Getter @Setter
public class OrganizedTravel extends Travel{
    private int nbDays ;
    private String country ;
    private String city ;
}
