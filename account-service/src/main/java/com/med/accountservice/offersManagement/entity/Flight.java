package com.med.accountservice.offersManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.med.accountservice.stationsManagement.entity.Airport;
import com.med.accountservice.usersManagement.dto.ProviderResponse;
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
    private int flightNumber ;
    private String aircraft ;
    @ManyToOne
    @JsonIgnore
    private Airline airline ;
    @ManyToOne
    private Airport from ;
    @ManyToOne
    private Airport to ;
    @ManyToMany(fetch = FetchType.EAGER )
    List<TravelClass> flightClasses ;
}
