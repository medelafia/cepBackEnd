package com.med.accountservice.usersManagement.service;

import com.med.accountservice.enums.AccountType;
import com.med.accountservice.exceptions.ExceptionDetails;
import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.imagesManagement.service.ImageService;
import com.med.accountservice.usersManagement.dto.CostumerUpdateRequest;
import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.entity.Costumer;
import com.med.accountservice.usersManagement.entity.Provider;
import com.med.accountservice.usersManagement.feignClient.ReviewsRepo;
import com.med.accountservice.usersManagement.model.Review;
import com.med.accountservice.usersManagement.repository.CostumerRepo ;
import com.med.accountservice.usersManagement.repository.ProviderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CostumerService {
    @Autowired
    private CostumerRepo costumerRepo ;
    @Autowired
    private PasswordEncoder passwordEncoder ;
    @Autowired
    private ReviewsRepo reviewsRepo ;
    @Autowired
    private ProviderRepo providerRepo ;
    @Autowired
    private ImageService imageService;
    public Account register(Costumer costumer) {
        costumer.setAccountType(AccountType.COSTUMER) ;
        costumer.setPassword(passwordEncoder.encode(costumer.getPassword()));
        return costumerRepo.save(costumer) ;
    }
    public void setRecommendationActivation(int id , boolean newStat) {
        Costumer costumer = costumerRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("account not found") ;
        }) ;
        costumer.setRecommendationProfileActivation(newStat);
        costumerRepo.save(costumer) ;
    }
    public List<Costumer> getAllCostumers() {
        return costumerRepo.findAll() ;
    }
    public Costumer updateInfo(int userId , CostumerUpdateRequest costumerUpdateRequest) {
        Costumer costumer = costumerRepo.findById(userId).orElseThrow(()->{
            throw new NoElementException("the account not found") ;
        }) ;
        if( costumer != null ){
            costumer.setAge(costumerUpdateRequest.getAge());
            costumer.setGender(costumerUpdateRequest.getGender());
            costumer.setFirstName(costumerUpdateRequest.getFirstName());
            costumer.setLastName(costumerUpdateRequest.getLastName());
            return costumerRepo.save(costumer) ;
        }
        return null  ;
    }
    public Review writeReview(Review review) {
        Provider provider = providerRepo.findById(review.getProviderId()).orElseThrow(()-> {
            throw new NoElementException("the provider not exist") ;
        }) ;
        Costumer costumer = costumerRepo.findById(review.getClientId()).orElseThrow(()->{
            throw new NoElementException("the costumer not exist") ;
        }) ;
        if(provider !=null && costumer != null ) {
            return reviewsRepo.writeReview(review) ;
        }
        return null ;
    }
    public Costumer changeProfile(int id , MultipartFile profileImage) {
        Costumer costumer = costumerRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("the costumer not found")  ;
        }) ;
        if(costumer != null ) {
            costumer.changeProfileImage(imageService.updloadImage(profileImage)) ;
            return costumerRepo.save(costumer) ;
        }
        return null ;
    }
}
