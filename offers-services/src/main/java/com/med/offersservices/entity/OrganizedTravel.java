package com.med.offersservices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.med.offersservices.model.Airport;
import com.med.offersservices.superClasses.Travel;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity @NoArgsConstructor @AllArgsConstructor @SuperBuilder
@Getter @Setter
public class OrganizedTravel extends Travel {
    private int nbDays ;
    private String country ;
    private String city ;
    private int travelAgencyId ;
    @JsonIgnore
    private int startAirportId ;
    @Transient
    private Airport startAirport ;
}
