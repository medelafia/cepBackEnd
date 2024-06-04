package com.med.accountservice.usersManagement.entity;

import com.med.accountservice.offersManagement.entity.TrainTravel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class RailwayOperator{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<TrainTravel> travelList ;
}
