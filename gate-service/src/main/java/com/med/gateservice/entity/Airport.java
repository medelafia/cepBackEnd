package com.med.gateservice.entity;

import com.med.gateservice.enums.AirportType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor @NoArgsConstructor @SuperBuilder
@Getter @Setter
public class Airport extends Gate{
    @Enumerated(value = EnumType.STRING)
    private AirportType airportType ;
}
