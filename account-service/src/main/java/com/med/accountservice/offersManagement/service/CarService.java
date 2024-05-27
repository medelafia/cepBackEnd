package com.med.accountservice.offersManagement.service;


import com.med.accountservice.offersManagement.repository.CarRepo;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private CarRepo carRepo;
    public CarService(CarRepo carRepo ) {
        this.carRepo = carRepo ;
    }
}
