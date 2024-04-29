package com.med.recommendationprofileservice.service;

import com.med.recommendationprofileservice.entity.RecommendationProfile;
import com.med.recommendationprofileservice.repository.RecommendationProfileRepo;
import org.springframework.stereotype.Service;

@Service
public class RecommendationProfileService {
    RecommendationProfileRepo recommendationProfileRepo ;
    public RecommendationProfileService(RecommendationProfileRepo recommendationProfileRepo) {
        this.recommendationProfileRepo = recommendationProfileRepo ;
    }
    public RecommendationProfile findRecommendationProfileById(int id) {
        return recommendationProfileRepo.findById(id).orElseThrow() ;
    }
    public RecommendationProfile createNewRecommendationProfile(RecommendationProfile recommendationProfile) {
        return recommendationProfileRepo.save(recommendationProfile) ;
    }
}
