package com.med.accountservice.usersManagement.web;

import com.med.accountservice.usersManagement.dto.CostumerUpdateRequest;
import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.entity.Costumer;
import com.med.accountservice.usersManagement.model.Review;
import com.med.accountservice.usersManagement.service.AccountService;
import com.med.accountservice.usersManagement.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/costumer")
@CrossOrigin("http://localhost:5173")
public class CostumerController {
    @Autowired
    private CostumerService costumerService ;
    @GetMapping("/")
    public List<Costumer> getALLCostumers() {
        return costumerService.getAllCostumers() ;
    }
    @PostMapping("/update/{id}")
    public Costumer updateInfo(@PathVariable int id , @RequestBody CostumerUpdateRequest costumer) {
        return costumerService.updateInfo(id , costumer) ;
    }
    @PostMapping("/disableRecommendation/{id}")
    public void disableRecommendation(@PathVariable int id) {
        costumerService.setRecommendationActivation(id , false); ;
    }
    @PostMapping("/enableRecommendation/{id}")
    public void enableRecommendation(@PathVariable int id) {
        costumerService.setRecommendationActivation(id , true); ;
    }
    @PostMapping("/register")
    public Account register(@RequestBody Costumer costumer) {
        return costumerService.register(costumer) ;
    }
    @PostMapping("/writeReview")
    public Review writeReview(@RequestBody Review review) {
        return costumerService.writeReview(review) ;
    }
}
