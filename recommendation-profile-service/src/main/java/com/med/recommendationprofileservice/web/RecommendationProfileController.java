package com.med.recommendationprofileservice.web;

import com.med.recommendationprofileservice.service.RecommendationProfileService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationProfileController {
    RecommendationProfileService recommendationProfileService ;
    public RecommendationProfileController(RecommendationProfileService recommendationProfileService) {
        this.recommendationProfileService = recommendationProfileService ;
    }
}
