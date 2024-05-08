package com.med.accountservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.med.accountservice.model.RecommendationProfile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@SuperBuilder
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String firstName ;
    private String lastName ;
    private String gender ;
    private int age ;
    @JsonIgnore
    private int recommendationProfileId ;
    @Transient
    private RecommendationProfile recommendationProfile ;
}
