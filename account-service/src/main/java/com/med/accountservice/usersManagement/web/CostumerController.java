package com.med.accountservice.usersManagement.web;

import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.usersManagement.dto.CostumerUpdateRequest;
import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.entity.Costumer;
import com.med.accountservice.usersManagement.model.Review;
import com.med.accountservice.usersManagement.service.AccountService;
import com.med.accountservice.usersManagement.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @PostMapping("/{id}/update")
    public Costumer updateInfo(@PathVariable int id , @RequestBody CostumerUpdateRequest costumer) {
        return costumerService.updateInfo(id , costumer) ;
    }
    @PostMapping("/{id}/disableRecommendation")
    public void disableRecommendation(@PathVariable int id) {
        costumerService.setRecommendationActivation(id , false); ;
    }
    @PostMapping("/{id}/enableRecommendation")
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
    @PostMapping("/{id}/changeProfileImage")
    public Image changeProfileImage(@PathVariable int id ,  MultipartFile profile) {
        return costumerService.changeProfile(id , profile) ;
    }
}
