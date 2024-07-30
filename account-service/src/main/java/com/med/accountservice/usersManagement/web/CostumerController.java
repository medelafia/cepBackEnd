package com.med.accountservice.usersManagement.web;

import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.reservationManagement.entity.Reservation;
import com.med.accountservice.reviewsManagement.entity.Review;
import com.med.accountservice.usersManagement.dto.CostumerResponse;
import com.med.accountservice.usersManagement.dto.CostumerUpdateRequest;
import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.entity.Costumer;
import com.med.accountservice.usersManagement.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@RestController
@RequestMapping("/costumer")
@CrossOrigin("http://localhost:5173")
public class CostumerController {
    @Autowired
    private CostumerService costumerService ;
    @PostMapping("/update")
    public Costumer updateInfo(@RequestBody CostumerUpdateRequest costumer) {
        return costumerService.updateInfo(costumer) ;
    }
    @PostMapping("/disableRecommendation")
    public void disableRecommendation() {
        costumerService.setRecommendationActivation(false); ;
    }
    @PostMapping("/enableRecommendation")
    public void enableRecommendation() {
        costumerService.setRecommendationActivation(true); ;
    }
    @PostMapping("/writeReview")
    public Review writeReview(@RequestBody Review review) {
        return costumerService.writeReview(review) ;
    }
    @PostMapping("/changeProfileImage")
    public Image changeProfileImage(MultipartFile image) {
        return costumerService.changeProfile(image) ;
    }
    @GetMapping("/")
    public CostumerResponse getMyInfo() {
        return costumerService.getMyInfo() ;
    }
    @GetMapping("/reservations")
    public List<Reservation> getAllReservations() {
        return  costumerService.getAllReservations() ;
    }
}
