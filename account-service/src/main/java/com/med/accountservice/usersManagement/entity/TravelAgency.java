package com.med.accountservice.usersManagement.entity;

import com.med.accountservice.offersManagement.entity.OrganizedTravel;
import com.med.accountservice.offersManagement.entity.Travel;
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
public class TravelAgency extends Provider{
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<OrganizedTravel> travels ;
    public List<OrganizedTravel> createNewOrganizedTravel(OrganizedTravel organizedTravel) {
        travels.add(organizedTravel) ;
        return this.travels ;
    }
    public List<OrganizedTravel> deleteOrganizedTravelById(int id) {
        this.travels.stream().filter(organizedTravel -> {
            return organizedTravel.getId() != id ;
        }).collect(Collectors.toList()) ;
        return this.travels ;
    }
}
