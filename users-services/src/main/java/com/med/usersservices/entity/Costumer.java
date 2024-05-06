package com.med.usersservices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.med.usersservices.model.RecommendationProfile;
import jakarta.persistence.*;
import lombok.*;
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
