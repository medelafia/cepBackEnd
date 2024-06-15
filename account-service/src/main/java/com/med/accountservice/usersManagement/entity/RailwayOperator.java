package com.med.accountservice.usersManagement.entity;

import com.med.accountservice.offersManagement.entity.TrainTravel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class RailwayOperator extends Provider{
    @ManyToMany(fetch = FetchType.EAGER)
    private List<TrainTravel> travelList ;
    public List<TrainTravel> createNewTrainTravel(TrainTravel trainTravel) {
        travelList.add(trainTravel);
        return this.travelList ;
    }
    public List<TrainTravel> deleteTrainTravelById(int id) {
        travelList.stream().filter(trainTravel -> {
            return trainTravel.getId() != id ;
        }).collect(Collectors.toList()) ;
        return this.travelList ;
    }

}
