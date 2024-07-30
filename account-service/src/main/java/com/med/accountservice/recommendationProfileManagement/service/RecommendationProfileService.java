package com.med.accountservice.recommendationProfileManagement.service;


import com.med.accountservice.recommendationProfileManagement.entity.RecommendationProfile;
import com.med.accountservice.recommendationProfileManagement.repository.RecommendationProfileRepo;
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
