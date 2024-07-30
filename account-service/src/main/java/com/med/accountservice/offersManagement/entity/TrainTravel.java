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

@Entity @AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
@SuperBuilder
public class TrainTravel extends Travel {
    private String trainName ;
    @JsonIgnore
    @ManyToOne
    RailwayOperator railwayOperator ;
    @ManyToOne
    TrainStation from ;
    @OneToOne
    TrainStation to ;
    @ManyToMany
    List<TravelClass> trainTravelClasses ;
}
