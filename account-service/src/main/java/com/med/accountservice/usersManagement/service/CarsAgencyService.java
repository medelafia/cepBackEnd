package com.med.accountservice.usersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.offersManagement.entity.Car;
import com.med.accountservice.offersManagement.repository.CarRepo;
import com.med.accountservice.usersManagement.entity.CarsAgency;
import com.med.accountservice.usersManagement.mapper.ProviderMapper;
import com.med.accountservice.usersManagement.repository.CarsAgencyRepo;
import com.netflix.discovery.converters.Auto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsAgencyService {
    @Autowired
    private CarsAgencyRepo carsAgencyRepo ;
    @Autowired
    private CarRepo carRepo ;
    public CarsAgency addCar(int providerId , Car car) {
        CarsAgency carsAgency = carsAgencyRepo.findById(providerId).orElseThrow(()->{
            throw new NoElementException("the car agency not found") ;
        }) ;
        carsAgency.createNewCar(carRepo.save(car)) ;
        return carsAgencyRepo.save(carsAgency);
    }
    public List<Car> getAllCarsByCarAgencyId(int id) {
        if(carsAgencyRepo.findById(id).isPresent()) {
            CarsAgency carsAgency = carsAgencyRepo.findById(id).get() ;
            return carsAgency.getCars() ;
        }else {
            throw new NoElementException("the car agency doesn't exist") ;
        }
    }
}
