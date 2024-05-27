package com.med.accountservice.offersManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.med.accountservice.stationsManagement.entity.TrainStation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity @AllArgsConstructor @SuperBuilder
@Getter @Setter
@NoArgsConstructor
public class TrainTravel extends Travel {
    private int railWaysOperatorId ;
    @ManyToOne
    TrainStation startTrainStation ;
    @OneToOne
    TrainStation arrivalTrainStation ;
    @ManyToMany(fetch = FetchType.EAGER)
    List<TrainStation> passedTrainStations ;
}
