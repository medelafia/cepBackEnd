package com.med.accountservice.offersManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.med.accountservice.stationsManagement.entity.TrainStation;
import com.med.accountservice.usersManagement.entity.RailwayOperator;
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
    @ManyToOne(cascade = CascadeType.REMOVE)
    RailwayOperator railwayOperator ;
    @ManyToOne
    TrainStation from ;
    @OneToOne
    TrainStation to ;
    @ManyToMany(fetch = FetchType.EAGER)
    List<TrainStation> passedTrainStations ;
}
