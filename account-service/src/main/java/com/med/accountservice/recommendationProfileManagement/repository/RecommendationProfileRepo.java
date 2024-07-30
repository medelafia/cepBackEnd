package com.med.accountservice.recommendationProfileManagement.repository;


import com.med.accountservice.recommendationProfileManagement.entity.RecommendationProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationProfileRepo extends JpaRepository<RecommendationProfile, Integer> {
}
