package com.med.accountservice.reviewsManagement.mappers;

import com.med.accountservice.reviewsManagement.dto.ReviewDto;
import com.med.accountservice.reviewsManagement.entity.Review;

import java.sql.Date;
import java.time.LocalDate;

public class ReviewMapper {
    public static Review toReview(ReviewDto reviewDto ) {
        Review review = Review.builder()
                .content(reviewDto.getContent())
                .date(Date.valueOf(LocalDate.now()))
                .score(reviewDto.getScore())
                .build() ;
        return review ;
    }
}
