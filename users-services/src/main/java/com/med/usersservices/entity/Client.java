package com.med.usersservices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.med.usersservices.model.RecommendationProfile;
import jakarta.persistence.Access;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@SuperBuilder
public class Client extends User{
    private String firstName ;
    private String lastName ;
    private String gender ;
    private int age ;
    @JsonIgnore
    private int recommendationProfileId ;
    @Transient
    private RecommendationProfile recommendationProfile ;
}
