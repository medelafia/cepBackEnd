package com.med.accountservice.usersManagement.mapper;

import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.entity.Provider;

public class ProviderMapper {
    public static ProviderResponse toProviderResponse(Provider provider) {
        return ProviderResponse.builder()
                .logo(provider.getLogo())
                .images(provider.getImages())
                .score(provider.getScore())
                .name(provider.getName())
                .email(provider.getEmail())
                .webSiteUrl(provider.getWebSiteUrl())
                .reviewsCount(provider.getNbReviews())
                .nbPhone(provider.getTel())
                .build() ;
    }
}
