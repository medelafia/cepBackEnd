package com.med.accountservice.usersManagement.web;

import com.med.accountservice.usersManagement.service.TravelAgencyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/travelAgencies")
@AllArgsConstructor
public class TravelAgencyController {
    private TravelAgencyService travelAgencyService ;
}
