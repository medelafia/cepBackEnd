package com.med.reviewsservice.web;

import com.med.reviewsservice.entity.Review;
import com.med.reviewsservice.service.ReviewService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    ReviewService reviewService ;
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService ;
    }
    @GetMapping("/{id}")
    public List<Review> findAllReviewsByProviderId(@PathVariable int id) {
        return reviewService.getReviewsByProviderId(id) ;
    }
    @PostMapping("/{id}")
    public void deleteReviewById(@PathVariable int id) {
        reviewService.deleteReviewById(id);
    }
    @PostMapping("/")
    public Review writeReview(@RequestBody Review review) {
        return reviewService.writeReview(review) ;
    }
    @GetMapping("/scoreAvg/{id}")
    public float getReviewsAvgForProvider(@PathVariable int id) {
        return reviewService.getProviderScore(id);
    }
    @GetMapping("/count/{id}")
    public int getReviewsCountForProvider(@PathVariable  int id ) {
        return reviewService.getProviderReviewsCount(id);
    }
}
