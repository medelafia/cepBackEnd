package com.med.offersservices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.med.offersservices.model.Airport;
import com.med.offersservices.superClasses.Travel;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Getter @Setter
public class Flight extends Travel {
    private int airlineId ;
    @JsonIgnore
    private int startAirportId ;
    @JsonIgnore
    private int arrivedAirportId ;
    @Transient
    private Airport startAirport ;
    @Transient
    private Airport arrivedAirport ;

}
