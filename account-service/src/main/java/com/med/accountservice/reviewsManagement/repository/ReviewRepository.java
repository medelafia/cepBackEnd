package com.med.accountservice.reviewsManagement.repository;


import com.med.accountservice.reviewsManagement.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review , Integer > {
    @Query("SELECT r FROM Review r where r.provider.id=:id")
    public List<Review> findAllByProviderId(int id) ;
    @Query("SELECT AVG(r.score) FROM Review r where r.provider.id=:id")
    public float getProviderScore(int id) ;
}
