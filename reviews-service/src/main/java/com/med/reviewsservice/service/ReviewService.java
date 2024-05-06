package com.med.reviewsservice.service;


import com.med.reviewsservice.entity.Review;
import com.med.reviewsservice.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    ReviewRepository reviewRepository ;
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository ;
    }
    public Review getReviewById(int id) {
        return reviewRepository.findById(id).get() ;
    }
}
