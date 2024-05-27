package com.med.accountservice.offersManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.med.accountservice.enums.FlightClass;
import com.med.accountservice.enums.FlightType;
import com.med.accountservice.stationsManagement.entity.Airport;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Getter @Setter
public class Flight extends Travel{
    private int airlineId ;
    @Enumerated(value = EnumType.STRING )
    private FlightClass flightClass ;
    @ManyToOne
    private Airport startAirport ;
    @OneToOne
    private Airport arrivedAirport ;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Airport> passedAirports ;
    private FlightType flightType ;
}
