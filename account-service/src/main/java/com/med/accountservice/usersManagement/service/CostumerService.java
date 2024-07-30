package com.med.accountservice.usersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.imagesManagement.service.ImageService;
import com.med.accountservice.reservationManagement.entity.Reservation;
import com.med.accountservice.reviewsManagement.entity.Review;
import com.med.accountservice.reviewsManagement.service.ReviewService;
import com.med.accountservice.usersManagement.dto.CostumerResponse;
import com.med.accountservice.usersManagement.dto.CostumerUpdateRequest;
import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.entity.Costumer;
import com.med.accountservice.usersManagement.entity.Provider;
import com.med.accountservice.usersManagement.mapper.CostumerMapper;
import com.med.accountservice.usersManagement.repository.CostumerRepo ;
import com.med.accountservice.usersManagement.repository.ProviderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CostumerService {
    @Autowired
    private CostumerRepo costumerRepo ;
    @Autowired
    private PasswordEncoder passwordEncoder ;
    @Autowired
    private ProviderRepo providerRepo ;
    @Autowired
    private ImageService imageService;
    @Autowired
    private ReviewService reviewService ;
    public Costumer getPrincipal() {
        return costumerRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get() ;
    }

    public void setRecommendationActivation(boolean newStat) {
        Costumer costumer = this.getPrincipal() ;
        costumer.setRecommendationProfileActivation(newStat);
        costumerRepo.save(costumer) ;
    }
    public Costumer updateInfo(CostumerUpdateRequest costumerUpdateRequest) {
        Costumer costumer = this.getPrincipal() ;
        costumer.setAge(costumerUpdateRequest.getAge());
        costumer.setGender(costumerUpdateRequest.getGender());
        costumer.setFirstName(costumerUpdateRequest.getFirstName());
        costumer.setLastName(costumerUpdateRequest.getLastName());
        return costumerRepo.save(costumer) ;
    }
    public Review writeReview(Review travelReview) {
        travelReview.setCostumer(this.getPrincipal());
        Provider provider = providerRepo.findById(travelReview.getProvider().getId()).get() ;
        travelReview.setProvider(provider);
        return reviewService.writeReview(travelReview) ;
    }
    public Image changeProfile(MultipartFile profileImage) {
        Costumer costumer = this.getPrincipal();
        Image image = imageService.updloadImage(profileImage) ;
        costumer.changeProfileImage(image) ;
        costumerRepo.save(costumer) ;
        return image ;
    }
    public List<Integer> findAllCostumersIds() {
        return costumerRepo.findAll()
                .stream()
                .filter(costumer -> costumer.isRecommendationProfileActivation() == true )
                .collect(Collectors.toList())
                .stream()
                .map(costumer -> costumer.getId())
                .collect(Collectors.toList());

    }
    public CostumerResponse getMyInfo() {
        return CostumerMapper.toCostumerResponse(this.getPrincipal()) ;
    }

    public List<Reservation> getAllReservations() {
        return new ArrayList<>();
    }
}
