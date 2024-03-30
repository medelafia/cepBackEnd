package com.med.usersservices.entity;

import com.med.usersservices.model.TrainTravel;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RailwayOperator extends Provider{
    @Transient
    private List<TrainTravel> trainTravels ;
}
