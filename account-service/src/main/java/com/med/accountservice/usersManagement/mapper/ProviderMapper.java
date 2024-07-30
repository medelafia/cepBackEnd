package com.med.accountservice.usersManagement.mapper;

import com.med.accountservice.usersManagement.dto.HotelResponse;
import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.entity.Hotel;
import com.med.accountservice.usersManagement.entity.Provider;

public class ProviderMapper {
    public static ProviderResponse toProviderResponse(Provider provider) {
        return ProviderResponse.builder()
                .id(provider.getId())
                .logo(provider.getLogo())
                .images(provider.getImages())
                .score(provider.getScore())
                .name(provider.getName())
                .email(provider.getEmail())
                .webSiteUrl(provider.getWebSiteUrl())
                .reviewsCount(provider.getNbReviews())
                .tel(provider.getTel())
                .description(provider.getDescription())
                .providerType(provider.getRole().substring(9))
                .build() ;
    }
    public static HotelResponse toHotelResponse(Hotel hotel) {
        return HotelResponse.builder()
                .id(hotel.getId())
                .logo(hotel.getLogo())
                .images(hotel.getImages())
                .score(hotel.getScore())
                .name(hotel.getName())
                .email(hotel.getEmail())
                .webSiteUrl(hotel.getWebSiteUrl())
                .reviewsCount(hotel.getNbReviews())
                .tel(hotel.getTel())
                .description(hotel.getDescription())
                .longitude(hotel.getLongitude())
                .latitude(hotel.getLatitude())
                .amenitieList(hotel.getAmenities())
                .build() ;
    }
}
