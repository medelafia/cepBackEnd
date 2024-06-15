package com.med.reviewsservice.service;


import com.med.reviewsservice.entity.Review;
import com.med.reviewsservice.repository.ReviewRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
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
        if(this.getReviewsByProviderId(id).size() != 0 ) {
            return reviewRepository.getScoreAverage(id) ;
        }
        return 0.00f;
    }
    public int getProviderReviewsCount(int id) {
        return reviewRepository.getReviewsCountsByProviderId(id) ;
    }
    public Review writeReview(Review review) {
        review.setDate(Date.valueOf(LocalDate.now()));
        return reviewRepository.save(review) ;
    }
}
