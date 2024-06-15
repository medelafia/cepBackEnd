package com.med.accountservice.offersManagement.service;


import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.offersManagement.entity.Car;
import com.med.accountservice.offersManagement.repository.CarRepo;
import com.med.accountservice.stationsManagement.entity.Airport;
import com.med.accountservice.stationsManagement.repository.AirportRepo;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepo carRepo;
    @Autowired
    private AirportRepo airportRepo ;
    public List<Car> findAllCarsByProprieties() {
        return carRepo.findAll() ;
    }
    public List<Car> getAllCars() {
        return carRepo.findAll() ;
    }
    public Car getCarById(int id) {
        Car car = carRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("the car doesn't exist") ;
        }) ;
        return car == null ? null : car ;
    }

    public boolean checkAvailable(int id) {
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
    public List<Car> getAllCarsAvailableInAirportAndNbSeats(String airportId , int nbSeats ){
        Airport airport = airportRepo.findById(airportId).orElseThrow(()->{
            throw new NoElementException("the airport nor found") ;
        })  ;
        return carRepo.findAllByAvailableInAndNumberOfSeats(airport , nbSeats) ;
    }
}
