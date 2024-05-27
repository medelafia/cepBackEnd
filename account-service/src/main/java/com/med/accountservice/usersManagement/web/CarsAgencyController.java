package com.med.accountservice.usersManagement.web;


import com.med.accountservice.usersManagement.service.CarsAgencyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carsAgencies")
@AllArgsConstructor
public class CarsAgencyController {
    private CarsAgencyService carsAgencyService ;
}
