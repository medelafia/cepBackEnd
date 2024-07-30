package com.med.accountservice.offersManagement.service;


import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.imagesManagement.service.ImageService;
import com.med.accountservice.offersManagement.entity.Car;
import com.med.accountservice.offersManagement.repository.CarRepo;
import com.med.accountservice.stationsManagement.entity.Airport;
import com.med.accountservice.stationsManagement.repository.AirportRepo;
import com.med.accountservice.usersManagement.mapper.ProviderMapper;
import com.med.accountservice.usersManagement.repository.ProviderRepo;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    @Autowired
    private CarRepo carRepo;
    @Autowired
    private AirportRepo airportRepo ;
    @Autowired
    private ProviderRepo providerRepo ;
    @Autowired
    private ImageService imageService ;
    public List<Car> getAllCars() {
        return this.carRepo.findAll() ;
    }
    public List<Car> getAllCars(int airportId , int nbSeats ) {
        return carRepo.findAllByAirportAndSeats(airportRepo.findById(airportId).get() , nbSeats ).stream().map(car -> {
            car.setProvider(ProviderMapper.toProviderResponse(car.getCarsAgency()));
            return car ;
        }).collect(Collectors.toList());
    }
    public Car getCarById(int id) {
        if(carRepo.findById(id).isPresent()) {
            return carRepo.findById(id).get() ;
        }else {
            throw new NoElementException("the car doesn't exist") ;
        }
    }

    public boolean checkAvailable(int id , Date checkIn , Date checkOut) {
        Car car =  this.getCarById(id) ;
        if(car != null) {
            return car.isAvailable()  ;
        }
        return false ;
    }

    public Car setAvailable(int id) {
        Car car = this.getCarById(id) ;
        if(car != null) {
            car.setAvailable(!car.isAvailable()) ;
            return carRepo.save(car);
        }
        return null ;
    }

}
