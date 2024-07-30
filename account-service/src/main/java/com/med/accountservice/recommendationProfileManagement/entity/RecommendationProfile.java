package com.med.accountservice.recommendationProfileManagement.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Builder
public class RecommendationProfile {
    @Id
    private  int id ;
    private int minBudget ;
    private int maxBudget ;
}
