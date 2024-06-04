package com.med.reviewsservice.service;


import com.med.reviewsservice.entity.Review;
import com.med.reviewsservice.repository.ReviewRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    ReviewRepository reviewRepository ;
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository ;
    }
    public List<Review> getReviewsByProviderId(int id) {
        return reviewRepository.findAllByProviderId(id) ;
    }
    public void deleteReviewById(int id) {
        reviewRepository.deleteById(id);
    }
    public float getProviderScore(int id) {
        return reviewRepository.getScoreAverage(id) ;
    }
    public int getProviderReviewsCount(int id) {
        return reviewRepository.getReviewsCountsByProviderId(id) ;
    }
}
