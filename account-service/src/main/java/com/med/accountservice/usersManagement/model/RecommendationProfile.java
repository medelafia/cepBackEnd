package com.med.accountservice.usersManagement.model;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class RecommendationProfile {
    private int minBudget ;
    private int maxBudget ;
}
