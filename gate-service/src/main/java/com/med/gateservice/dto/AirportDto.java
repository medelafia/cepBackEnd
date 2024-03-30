package com.med.gateservice.dto;

import com.med.gateservice.enums.AirportType;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class AirportDto extends GateDto{
    private AirportType airportType ;
}
