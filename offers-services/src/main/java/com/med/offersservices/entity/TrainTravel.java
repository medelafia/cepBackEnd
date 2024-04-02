package com.med.offersservices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.med.offersservices.model.TrainStation;
import com.med.offersservices.superClasses.Travel;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity @AllArgsConstructor @SuperBuilder
@Getter @Setter
@NoArgsConstructor
public class TrainTravel extends Travel {
    private int railWaysOperatorId ;
    @JsonIgnore
    private int startStationId ;
    @JsonIgnore
    private int arrivedStationId ;
    @Transient
    private TrainStation startTrainStation ;
    @Transient
    private TrainStation arriverTrainStation ;
}
