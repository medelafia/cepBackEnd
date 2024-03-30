package com.med.gateservice.entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor @NoArgsConstructor @SuperBuilder @Getter @Setter
public class TrainStation extends Gate {
    private int platformNb ;
}
