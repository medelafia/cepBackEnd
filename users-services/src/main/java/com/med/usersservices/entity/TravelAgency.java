package com.med.usersservices.entity;

import com.med.usersservices.model.OrganizedTravel;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class TravelAgency extends Provider{
    @Transient
    private List<OrganizedTravel> organizedTravels ;
}
