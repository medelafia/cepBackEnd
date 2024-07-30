package com.med.accountservice.usersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.imagesManagement.service.ImageService;
import com.med.accountservice.reservationManagement.entity.Reservation;
import com.med.accountservice.reservationManagement.service.ReservationService;
import com.med.accountservice.reviewsManagement.service.ReviewService;
import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.dto.ProviderUpdateRequest;
import com.med.accountservice.usersManagement.entity.*;
import com.med.accountservice.usersManagement.mapper.ProviderMapper;
import com.med.accountservice.usersManagement.repository.*;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProviderService {
    @Autowired
    ProviderRepo providerRepo ;
    @Autowired
    AirlineRepo airlineRepo ;
    @Autowired
    CarsAgencyRepo carsAgencyRepo ;
    @Autowired
    RailwayOperatorRepo railwayOperatorRepo ;
    @Autowired
    TravelAgencyRepo travelAgencyRepo ;
    @Autowired
    PasswordEncoder passwordEncoder ;
    @Autowired
    HotelRepo hotelRepo ;
    @Autowired
    ImageService imageService ;
    @Autowired
    ReviewService reviewService ;
    @Autowired
    ReservationService reservationService ;
    public Provider getAuthenticatedProvider() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName() ;
        Provider provider = providerRepo.findByUsername(username).get() ;
        return provider ;
    }
    public ProviderResponse getProviderInfo(int id) {
        Provider provider = this.providerRepo.findById(id).get();
        provider.setScore(reviewService.getProviderScore(id));
        provider.setNbReviews(reviewService.getProviderReviewsCount(id));
        return ProviderMapper.toProviderResponse(provider);
    }
    public ProviderResponse getProviderInfo() {
        Provider provider = this.getAuthenticatedProvider();
        provider.setScore(reviewService.getProviderScore(provider.getId()));
        provider.setNbReviews(reviewService.getProviderReviewsCount(provider.getId()));
        return ProviderMapper.toProviderResponse(provider);
    }
    public Provider changeLogo(MultipartFile file) {
        Provider provider = this.getAuthenticatedProvider() ;
        Image image = imageService.updloadImage(file) ;
        provider.changeLogo(image) ;
        return providerRepo.save(provider) ;
    }
    public Provider updateProviderInfo(ProviderUpdateRequest providerUpdateRequest) {
        Provider provider = this.getAuthenticatedProvider();
        provider.setFax(providerUpdateRequest.getFax());
        provider.setName(providerUpdateRequest.getName());
        provider.setWebSiteUrl(providerUpdateRequest.getWebSite());
        return providerRepo.save(provider) ;
    }

    public List<Image> getAllImages() {
        return this.getAuthenticatedProvider().getImages() ;
    }

    public List<Image> addImages(MultipartFile[] images) {
        Provider provider = this.getAuthenticatedProvider() ;
        List<Image> imagesList = imageService.uploadImages(images);
        provider.addImages(imagesList) ;
        return providerRepo.save(provider).getImages() ;
    }

    public void deleteImages(List<Integer> imagesIds) {
        if(!imagesIds.isEmpty()) {
            Provider provider = this.getAuthenticatedProvider() ;
            for( int imageId : imagesIds) {
                provider.getImages().stream().filter(image -> image.getId() != imageId) ;
            }
            provider.setImages(provider.getImages());
            providerRepo.save(provider) ;
        }
    }
    public List<Reservation> getAllReservations() {
        return null ;
    }
    public List<ProviderResponse> getAllProviders() {
        return providerRepo.findAll().stream().map(provider -> ProviderMapper.toProviderResponse(provider)).collect(Collectors.toList());
    }
}
