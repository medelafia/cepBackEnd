package com.med.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class OrganizedTravel extends Travel{
    private int nbDays ;
    private String country ;
    private String city ;
}