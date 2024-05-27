package com.med.accountservice.offersManagement.entity;

import com.med.accountservice.stationsManagement.entity.Airport;
import com.med.accountservice.usersManagement.entity.TravelAgency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor @SuperBuilder
@Getter @Setter
public class OrganizedTravel extends Travel {
    private int nbDays ;
    private String country ;
    private String city ;
    @ManyToOne
    private Airport startAirport ;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Airport> passedAirport ;
}
