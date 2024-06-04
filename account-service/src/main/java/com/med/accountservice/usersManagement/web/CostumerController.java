package com.med.accountservice.usersManagement.web;

import com.med.accountservice.usersManagement.entity.Costumer;
import com.med.accountservice.usersManagement.service.CostumerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @AllArgsConstructor
@RequestMapping("/costumers")
@CrossOrigin("http://localhost:5173")
public class CostumerController {
    private CostumerService costumerService ;
    @GetMapping("/{id}")
    public Costumer getCostumerById(@PathVariable int id) {
        return costumerService.getCostumerById(id) ;
    }
    @PostMapping("/update/")
    public Costumer updateCostumer(Costumer costumer) {
        return costumerService.updateCostumer(costumer) ;
    }
    @GetMapping("/")
    private List<Costumer> getAllCostumers(@RequestParam int page)
    {
        return costumerService.getAllCostumers(page) ;
    }
}
