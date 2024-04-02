package com.med.offersservices.model;


import com.med.offersservices.enums.AirportType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor @NoArgsConstructor @SuperBuilder
@Getter @Setter
public class Airport extends Gate{
    private AirportType airportType ;
}
