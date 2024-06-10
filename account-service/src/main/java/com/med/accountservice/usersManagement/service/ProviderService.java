package com.med.accountservice.usersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.entity.Provider;
import com.med.accountservice.usersManagement.feignClient.ReviewsRepo;
import com.med.accountservice.usersManagement.repository.ProviderRepo;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {
    @Autowired
    ProviderRepo providerRepo ;
    @Autowired
    ReviewsRepo reviewsRepo ;
    public ProviderResponse getProviderInfo(int id) {
        Provider provider = providerRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("the provider not found") ;
        }) ;
        ProviderResponse providerResponse = ProviderResponse.builder()
                .name(provider.getCompanyName())
                .email(provider.getEmail())
                .webSiteUrl(provider.getWebSiteUrl())
                .reviewsCount(reviewsRepo.getReviewsCount(provider.getId()))
                .score(reviewsRepo.getScoreAvg(provider.getId()))
                .reviews(reviewsRepo.getAllReviewsByProviderId(provider.getId()))
                .images(provider.getImages())
                .logo(provider.getLogo())
                .build() ;
        return providerResponse ;
    }
}
