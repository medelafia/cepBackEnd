package com.med.gateservice.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class TrainStationDto extends GateDto {
    private int platformNb ;
}
