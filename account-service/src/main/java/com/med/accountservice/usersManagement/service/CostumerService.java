package com.med.accountservice.usersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.entity.Costumer;
import com.med.accountservice.usersManagement.feignClient.RecommendationProfileRepo;
import com.med.accountservice.usersManagement.repository.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CostumerService {
    private CustomerRepo customerRepo ;
    private RecommendationProfileRepo recommendationProfileRepo ;
    public Costumer getCostumerById(int id) {
        Costumer costumer = customerRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("costumer not found") ;
        }) ;
        costumer.setRecommendationProfile(recommendationProfileRepo.getRecommendationProfileById(costumer.getRecommendationProfileId()));
        return costumer ;
    }
    public Costumer updateCostumer(Costumer costumer) {
        return customerRepo.save(costumer) ;
    }
    public List<Costumer> getAllAccounts() {
        return customerRepo.findAll() ;
    }

}
