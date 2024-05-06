package com.med.reviewsservice.repository;

import com.med.reviewsservice.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review , Integer > {
}
