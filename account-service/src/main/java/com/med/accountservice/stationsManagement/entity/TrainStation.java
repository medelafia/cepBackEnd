package com.med.accountservice.stationsManagement.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor @NoArgsConstructor @SuperBuilder @Getter @Setter
public class TrainStation extends Gate {
    private int platformNb ;
}
