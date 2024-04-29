package com.med.recommendationprofileservice.web;

import com.med.recommendationprofileservice.entity.RecommendationProfile;
import com.med.recommendationprofileservice.service.RecommendationProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationProfileController {
    RecommendationProfileService recommendationProfileService ;
    public RecommendationProfileController(RecommendationProfileService recommendationProfileService) {
        this.recommendationProfileService = recommendationProfileService ;
    }
    @GetMapping("/{id}")
    public RecommendationProfile findRecommendationProfileById(@PathVariable int id) {
        return recommendationProfileService.findRecommendationProfileById(id) ;
    }
    @PostMapping("/")
    public RecommendationProfile createNewRecommendationProfile(RecommendationProfile recommendationProfile) {
        return recommendationProfileService.createNewRecommendationProfile(recommendationProfile) ;
    }
}
