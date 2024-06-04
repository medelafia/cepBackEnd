package com.med.accountservice.usersManagement.feignClient;

import com.med.accountservice.usersManagement.model.Review;
import org.apache.catalina.LifecycleState;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "reviews-service" , url = "http://localhost:8090")
public interface ReviewsRepo {
    @GetMapping("/{id}")
    public List<Review> getAllReviewsByProviderId(@PathVariable int id) ;
}
