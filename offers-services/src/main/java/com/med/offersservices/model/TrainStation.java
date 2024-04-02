package com.med.offersservices.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor @NoArgsConstructor @SuperBuilder @Getter @Setter
public class TrainStation extends Gate {
    private int platformNb ;
}
