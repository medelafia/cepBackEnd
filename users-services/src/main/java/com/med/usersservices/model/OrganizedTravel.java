package com.med.usersservices.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class OrganizedTravel extends Travel{
    private int nbDays ;
    private String country ;
    private String city ;
}
