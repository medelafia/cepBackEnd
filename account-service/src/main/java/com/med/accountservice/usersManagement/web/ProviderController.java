package com.med.accountservice.usersManagement.web;

import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.entity.Provider;
import com.med.accountservice.usersManagement.service.AccountService;
import com.med.accountservice.usersManagement.service.ProviderService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provider")
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
}