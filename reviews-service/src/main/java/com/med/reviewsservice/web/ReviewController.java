package com.med.reviewsservice.web;

import com.med.reviewsservice.service.ReviewService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    ReviewService reviewService ;
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService ;
    }
}
