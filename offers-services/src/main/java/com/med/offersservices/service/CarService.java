package com.med.offersservices.service;

import com.med.offersservices.entity.Car;
import com.med.offersservices.model.Image;
import com.med.offersservices.repositry.CarRepo;
import com.med.offersservices.repositry.ImageRepo;
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
    public List<Car> getCarsByIds(List<Integer> ids)  {
        return carRepo.findAllById(ids) ;
    }
    public Car getCarById(int id){
        Car car = carRepo.findById(id).get() ;
        Image image = imageRepo.getImageById(car.getImageId()) ;
        car.setImage(image);
        return car ;
    }
    public void deleteCarById(int id) {
        carRepo.deleteById(id);
    }
}
