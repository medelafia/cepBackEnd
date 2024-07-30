package com.med.accountservice.reviewsManagement.service;


import com.med.accountservice.reviewsManagement.entity.Review;
import com.med.accountservice.reviewsManagement.repository.ReviewRepository;
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
        List<Review> reviews = reviewRepository.findAllByProviderId(id) ;
        reviews.forEach(review -> {
            review.setCostumerFullName(review.getCostumer().getFirstName().concat(" "+review.getCostumer().getLastName()));
            review.setProvider(null);
            review.setCostumer(null);
        });
        return reviews;
    }
    public float getProviderScore(int id) {
        if(this.getReviewsByProviderId(id).size() != 0 ) {
            return reviewRepository.getProviderScore(id);
        }
        return 0.00f;
    }
    public int getProviderReviewsCount(int id) {
        return this.reviewRepository.findAllByProviderId(id).size();
    }
    public Review writeReview(Review review) {
        review.setDate(Date.valueOf(LocalDate.now()));
        return reviewRepository.save(review) ;
    }
}
