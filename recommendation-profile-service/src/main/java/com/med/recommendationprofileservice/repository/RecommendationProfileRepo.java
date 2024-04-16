package com.med.recommendationprofileservice.repository;

import com.med.recommendationprofileservice.entity.RecommendationProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationProfileRepo extends JpaRepository<RecommendationProfile , Integer> {
}
