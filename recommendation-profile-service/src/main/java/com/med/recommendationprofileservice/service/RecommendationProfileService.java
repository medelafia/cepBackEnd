package com.med.recommendationprofileservice.service;

import com.med.recommendationprofileservice.repository.RecommendationProfileRepo;
import org.springframework.stereotype.Service;

@Service
public class RecommendationProfileService {
    RecommendationProfileRepo recommendationProfileRepo ;
    public RecommendationProfileService(RecommendationProfileRepo recommendationProfileRepo) {
        this.recommendationProfileRepo = recommendationProfileRepo ;
    }
}
