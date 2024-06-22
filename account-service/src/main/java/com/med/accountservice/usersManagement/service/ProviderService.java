package com.med.accountservice.usersManagement.service;

import com.med.accountservice.enums.AccountType;
import com.med.accountservice.enums.ProviderType;
import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.imagesManagement.service.ImageService;
import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.entity.*;
import com.med.accountservice.usersManagement.feignClient.ReviewsRepo;
import com.med.accountservice.usersManagement.mapper.ProviderMapper;
import com.med.accountservice.usersManagement.model.Review;
import com.med.accountservice.usersManagement.repository.*;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
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
    ReviewsRepo reviewsRepo ;
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
    public ProviderResponse getProviderInfo(int id) {
        if(providerRepo.findById(id).isPresent()) {
            Provider provider = providerRepo.findById(id).get() ;
            return ProviderMapper.toProviderResponse(provider);
        }else {
            throw new NoElementException("the provider not found") ;
        }
    }
    public Provider register(Airline airline) {
        airline.setPassword(passwordEncoder.encode(airline.getPassword()));
        airline.setProviderType(ProviderType.AIRLINE);
        airline.setAccountType(AccountType.PROVIDER);
        return airlineRepo.save(airline) ;
    }
    public Provider register(CarsAgency carsAgency) {
        carsAgency.setPassword(passwordEncoder.encode(carsAgency.getPassword()));
        carsAgency.setAccountType(AccountType.PROVIDER);
        carsAgency.setProviderType(ProviderType.CARS_AGENCY);
        return carsAgencyRepo.save(carsAgency) ;
    }
    public Provider register(Hotel hotel) {
        hotel.setProviderType(ProviderType.HOTEL);
        hotel.setAccountType(AccountType.PROVIDER);
        hotel.setPassword(passwordEncoder.encode(hotel.getPassword()));
        return hotelRepo.save(hotel) ;
    }
    public Provider register(RailwayOperator railwayOperator) {
        railwayOperator.setPassword(passwordEncoder.encode(railwayOperator.getPassword()));
        railwayOperator.setProviderType(ProviderType.RAILWAY_OPERATOR);
        railwayOperator.setAccountType(AccountType.PROVIDER );
        return railwayOperatorRepo.save(railwayOperator) ;
    }
    public Provider register(TravelAgency travelAgency) {
        travelAgency.setPassword(passwordEncoder.encode(travelAgency.getPassword()));
        travelAgency.setAccountType(AccountType.PROVIDER);
        travelAgency.setProviderType(ProviderType.TRAVELS_AGENCY);
        return travelAgencyRepo.save(travelAgency) ;
    }
    public Review writeReview(Review review) {
        Provider provider = providerRepo.findById(review.getProviderId()).orElseThrow(()->{
            throw new NoElementException("the provider not found") ;
        }) ;
        if(provider != null) {
            return reviewsRepo.writeReview(review) ;
        }
        return null ;
    }
    public Provider changeLogo(int id , MultipartFile file) {
        Provider provider = providerRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("the provider not found") ;
        }) ;
        if(provider != null) {
            Image image = imageService.updloadImage(file) ;
            provider.changeLogo(image) ;
            return providerRepo.save(provider) ;
        }
        return null ;
    }

    public List<ProviderResponse> getAllProviders() {
        List<Provider> providers = providerRepo.findAll() ;
        List<ProviderResponse> providerResponses = providers.stream().map(provider -> ProviderMapper.toProviderResponse(provider)).collect(Collectors.toList()); ;
        return providerResponses;
    }
}
