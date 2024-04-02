package com.med.offersservices.service;

import com.med.offersservices.entity.Car;
import com.med.offersservices.repositry.CarRepo;
import com.med.offersservices.feignClient.ImageRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    CarRepo carRepo ;
    ImageRepo imageRepo ;
    public CarService(CarRepo carRepo , ImageRepo imageRepo ) {
        this.carRepo = carRepo ;
        this.imageRepo = imageRepo ;
    }
    public Car addNewCar(Car car){
        return carRepo.save(car) ;
    }
    public List<Car> getCarsByCarsAgencyId(int id) {
        return carRepo.findAllByCarAgencyId(id);
    }
    public void deleteCarById(int id) {
        carRepo.deleteById(id);
    }
    public List<Car> getAllCars(){
        return carRepo.findAll() ;
    }
}
