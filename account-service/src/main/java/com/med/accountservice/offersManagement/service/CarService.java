package com.med.accountservice.offersManagement.service;


import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.offersManagement.entity.Car;
import com.med.accountservice.offersManagement.repository.CarRepo;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private CarRepo carRepo;
    public CarService(CarRepo carRepo ) {
        this.carRepo = carRepo ;
    }
    public List<Car> findAllCarsByProprieties() {
        return carRepo.findAll() ;
    }
    public Car setAvailable(int id) {
        Car car = carRepo.findById(id).orElseThrow(()-> {
            throw new NoElementException("the car not exist");
        }) ;
        car.setAvailable(!car.isAvailable());
        return carRepo.save(car) ;
    }
    public boolean checkAvailable(int id) {
        Car car = carRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("the car not exist") ;
        }) ;
        return car.isAvailable() ;
    }
}
