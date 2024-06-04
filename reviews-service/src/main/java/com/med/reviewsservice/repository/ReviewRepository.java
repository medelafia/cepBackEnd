package com.med.reviewsservice.repository;

import com.med.reviewsservice.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review , Integer > {
    public List<Review> findAllByProviderId(int id) ;
    @Query(value = "SELECT AVG(r.score) from Review r WHERE r.providerId=:id GROUP BY r.providerId")
    public float getScoreAverage(int id) ;
    @Query(value = "SELECT sum(r.id) from Review r where r.providerId=:id")
    public int getReviewsCountsByProviderId(int id) ;
}
