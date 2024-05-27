package com.med.accountservice.usersManagement.service;

import com.med.accountservice.usersManagement.repository.CarsAgencyRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarsAgencyService {
    private CarsAgencyRepo carsAgencyRepo ;
}
