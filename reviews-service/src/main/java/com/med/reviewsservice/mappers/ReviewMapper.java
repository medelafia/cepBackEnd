package com.med.reviewsservice.mappers;

import com.med.reviewsservice.dto.ReviewDto;
import com.med.reviewsservice.entity.Review;

import java.sql.Date;
import java.time.LocalDate;

public class ReviewMapper {
    public static Review toReview(ReviewDto reviewDto ) {
        Review review = Review.builder()
                .content(reviewDto.getContent())
                .date(Date.valueOf(LocalDate.now()))
                .score(reviewDto.getScore())
                .providerId(reviewDto.getProviderId())
                .build() ;
        return review ;
    }
}
