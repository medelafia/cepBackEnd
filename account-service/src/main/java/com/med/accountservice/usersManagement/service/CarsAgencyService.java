package com.med.accountservice.usersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.imagesManagement.service.ImageService;
import com.med.accountservice.offersManagement.entity.Car;
import com.med.accountservice.offersManagement.repository.CarRepo;
import com.med.accountservice.stationsManagement.repository.AirportRepo;
import com.med.accountservice.usersManagement.dto.CarRequest;
import com.med.accountservice.usersManagement.entity.CarsAgency;
import com.med.accountservice.usersManagement.repository.CarsAgencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarsAgencyService {
    @Autowired
    private CarsAgencyRepo carsAgencyRepo ;
    @Autowired
    private CarRepo carRepo ;
    @Autowired
    private AirportRepo airportRepo ;
    @Autowired
    ImageService imageService ;
    public CarsAgency getAuthenticated() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName() ;
        return carsAgencyRepo.findByUsername(username).get();
    }
    public List<Car> addCar(MultipartFile carImage , Car car) {
            CarsAgency carsAgency = this.getAuthenticated() ;
            car.setAirport(airportRepo.findById(car.getAirport().getId()).get()) ;
            Image image = imageService.updloadImage(carImage) ;
            car.setImage(image) ;
            car.setCarsAgency(carsAgency);
            carsAgency.createNewCar(carRepo.save(car)) ;
            return carsAgencyRepo.save(carsAgency).getCars();
    }
    public List<Car> getAllCars() {
        return this.getAuthenticated().getCars() ;
    }

    public void deleteCar(int carId) {
            CarsAgency carsAgency = this.getAuthenticated() ;
            if(carRepo.findById(carId).isPresent()) {
                Car car = carRepo.findById(carId).get();
                if(carsAgency.getCars().contains(car)) {
                    carRepo.deleteById(carId);
                }else {
                    throw new NoElementException("your car agency doesn't have this car") ;
                }
            }else {
                throw new NoElementException("the car not exist ") ;
            }
    }

    public List<Car> updateCar(int carId, Car newCar) {
        CarsAgency carsAgency = this.getAuthenticated();
        if(carRepo.findById(carId).isPresent()) {
            Car car = carRepo.findById(carId).get() ;
            car.setAvailable(newCar.isAvailable());
            car.setAirConditioning(newCar.isAirConditioning());
            car.setFreeCancelation(newCar.isFreeCancelation());
            car.setMake(newCar.getMake());
            car.setModel(newCar.getModel());
            car.setFuelType(newCar.getFuelType());
            car.setDoors(newCar.getDoors());
            car.setSeats(newCar.getSeats());
            car.setBags(newCar.getBags());
            car.setStyleType(newCar.getStyleType());
            car.setTransType(newCar.getTransType()) ;
            car.setPrice(newCar.getPrice());
            car.setAirport(airportRepo.findById(newCar.getAirport().getId()).get()) ;
            carRepo.save(car);
            return carsAgencyRepo.save(carsAgency).getCars();
        }
        else {
            throw new NoElementException("the car not found") ;
        }
    }
}
