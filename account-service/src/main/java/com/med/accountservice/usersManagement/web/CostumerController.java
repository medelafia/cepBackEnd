package com.med.accountservice.usersManagement.web;

import com.med.accountservice.usersManagement.dto.CostumerUpdateRequest;
import com.med.accountservice.usersManagement.entity.Costumer;
import com.med.accountservice.usersManagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/costumer")
public class CostumerController {
    @Autowired
    private AccountService accountService ;
    @GetMapping("/")
    public List<Costumer> getALLCostumers() {
        return accountService.getAllCostumers() ;
    }
    @PostMapping("/update/{id}")
    public Costumer updateInfo(@PathVariable int id , @RequestBody CostumerUpdateRequest costumer) {
        return accountService.updateInfo(id , costumer) ;
    }
    @PostMapping("/disableRecommendation/{id}")
    public void disableRecommendation(@PathVariable int id) {
        accountService.setRecommendationActivation(id , false); ;
    }
    @PostMapping("/enableRecommendation/{id}")
    public void enableRecommendation(@PathVariable int id) {
        accountService.setRecommendationActivation(id , true); ;
    }

}
