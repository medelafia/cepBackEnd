package com.med.accountservice.usersManagement.web;

import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.entity.*;
import com.med.accountservice.usersManagement.model.Review;
import com.med.accountservice.usersManagement.service.AccountService;
import com.med.accountservice.usersManagement.service.ProviderService;
import com.netflix.discovery.converters.Auto;
import feign.template.HeaderTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/provider")
@CrossOrigin("http://localhost:5173")
public class ProviderController {
    @Autowired
    private AccountService accountService ;
    @Autowired
    private ProviderService providerService ;
    @GetMapping("/")
    public List<Provider> getAllProviders(){
        return accountService.getAllProviders() ;
    }
    @GetMapping("/{id}")
    public ProviderResponse getProvider(@PathVariable int id){
        return providerService.getProviderInfo(id) ;
    }
    @PostMapping("/register/airline")
    public Provider register(@RequestBody Airline airline) {
        return providerService.register(airline);
    }
    @PostMapping("/register/hotel")
    public Provider register(@RequestBody Hotel hotel) {
        return providerService.register(hotel) ;
    }
    @PostMapping("/register/railwaysOperator")
    public Provider register(@RequestBody RailwayOperator railwayOperator) {
        return providerService.register(railwayOperator) ;
    }
    @PostMapping("/register/carAgency")
    public Provider register(@RequestBody CarsAgency carsAgency) {
        return providerService.register(carsAgency) ;
    }
    @PostMapping("/register/travelAgency")
    public Provider register(@RequestBody TravelAgency travelAgency){
        return providerService.register(travelAgency) ;
    }
    @PostMapping("/{id}/changeLogo")
    public Provider changeLogo(@PathVariable int id ,  MultipartFile logo) {
        return providerService.changeLogo(id , logo) ;
    }
}