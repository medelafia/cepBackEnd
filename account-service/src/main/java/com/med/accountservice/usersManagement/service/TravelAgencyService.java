package com.med.accountservice.usersManagement.service;

import com.med.accountservice.usersManagement.repository.TravelAgencyRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TravelAgencyService{
    private TravelAgencyRepo travelAgencyRepo ;
}
