package com.med.accountservice.stationsManagement.entity;

import com.med.accountservice.enums.AirportType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor @NoArgsConstructor @SuperBuilder
@Getter @Setter
public class Airport extends Gate {
    private String iata ;
    @Enumerated(value = EnumType.STRING)
    private AirportType airportType ;
}
