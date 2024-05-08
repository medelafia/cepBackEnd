package com.med.accountservice.entity;

import com.med.accountservice.model.TrainTravel;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RailwayOperator extends Provider {
    @Transient
    private List<TrainTravel> trainTravels ;
}
