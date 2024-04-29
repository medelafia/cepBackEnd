package com.med.usersservices.feignRepo;

import com.med.usersservices.model.RecommendationProfile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "recommendation-profile-service" , url = "http://localhost:8086/")
public interface RecommendationProfileRepo {
    @RequestMapping(method = RequestMethod.GET , value = "/{id}")
    public RecommendationProfile getRecommendationProfileById(@PathVariable int id) ;
}
