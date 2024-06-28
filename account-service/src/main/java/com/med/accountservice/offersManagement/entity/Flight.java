package com.med.accountservice.offersManagement.entity;

import com.med.accountservice.enums.FlightType;
import com.med.accountservice.stationsManagement.entity.Airport;
import com.med.accountservice.usersManagement.entity.Airline;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Getter @Setter
public class Flight extends Travel{
    @ManyToOne
    private Airline airline ;
    @ManyToOne
    private Airport from ;
    @ManyToOne
    private Airport to ;
    @ManyToMany(fetch = FetchType.EAGER )
    List<TravelClass> flightClasses ;
    @ManyToMany(fetch = FetchType.EAGER )
    private List<Airport> passedAirports ;
    private FlightType flightType ;
}
