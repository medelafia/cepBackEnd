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
import org.springframework.stereotype.Service;

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
    public List<Car> addCar(int providerId , CarRequest carRequest) {
        if(carsAgencyRepo.findById(providerId).isPresent()) {
            CarsAgency carsAgency = carsAgencyRepo.findById(providerId).get() ;
            Car car = Car.builder()
                    .airConditioning(carRequest.isAirConditioning())
                    .available(carRequest.isAvailable())
                    .fuelType(carRequest.getFuelType())
                    .freeCancelation(carRequest.isFreeCancelation())
                    .make(carRequest.getMake())
                    .model(carRequest.getModel())
                    .price(carRequest.getPrice())
                    .doors(carRequest.getDoors())
                    .seats(carRequest.getSeats())
                    .bags(carRequest.getBags())
                    .transType(carRequest.getTransType())
                    .styleType(carRequest.getStyleType())
                    .build() ;
            car.setAirport(airportRepo.findById(carRequest.getAirportId()).get()) ;
            Image image = imageService.updloadImage(carRequest.getImage()) ;
            car.setImage(image) ;
            carsAgency.createNewCar(carRepo.save(car)) ;
            return carsAgencyRepo.save(carsAgency).getCars();
        }else {
            throw new NoElementException("the car agency not found") ;
        }
    }
    public List<Car> getAllCarsByCarAgencyId(int id) {
        if(carsAgencyRepo.findById(id).isPresent()) {
            CarsAgency carsAgency = carsAgencyRepo.findById(id).get() ;
            return carsAgency.getCars() ;
        }else {
            throw new NoElementException("the car agency doesn't exist") ;
        }
    }

    public void deleteCar(int id, int carId) {
        if(carsAgencyRepo.findById(id).isPresent()) {
            CarsAgency carsAgency = carsAgencyRepo.findById(id).get() ;
            if(carRepo.findById(carId).isPresent()) {
                Car car = carRepo.findById(carId).get();
                if(carsAgency.getCars().contains(car)) {
                    carsAgency.setCars(carsAgency.getCars().stream().filter(c -> c.getId() != carId).collect(Collectors.toList()));
                    carsAgencyRepo.save(carsAgency) ;
                    carRepo.deleteById(carId);
                }else {
                    throw new NoElementException("your car agency doesn't have this car") ;
                }
            }else {
                throw new NoElementException("the car not exist ") ;
            }
        }else {
            throw new NoElementException("the car agency not exist") ;
        }
    }

    public List<Car> updateCar(int providerId, int carId, CarRequest carRequest) {
        if(carsAgencyRepo.findById(providerId).isPresent()) {
            CarsAgency carsAgency = carsAgencyRepo.findById(providerId).get() ;
            if(carRepo.findById(carId).isPresent()) {
                Car car = carRepo.findById(carId).get() ;
                car.setAvailable(carRequest.isAvailable());
                car.setAirConditioning(carRequest.isAirConditioning());
                car.setFreeCancelation(carRequest.isFreeCancelation());
                car.setMake(carRequest.getMake());
                car.setModel(carRequest.getModel());
                car.setFuelType(carRequest.getFuelType());
                car.setDoors(carRequest.getDoors());
                car.setSeats(carRequest.getSeats());
                car.setBags(carRequest.getBags());
                car.setStyleType(carRequest.getStyleType());
                car.setTransType(carRequest.getTransType()) ;
                car.setPrice(carRequest.getPrice());
                car.setAirport(airportRepo.findById(carRequest.getAirportId()).get()) ;
                Image image = imageService.updloadImage(carRequest.getImage()) ;
                car.setImage(image) ;
                carRepo.save(car);
                return carsAgencyRepo.save(carsAgency).getCars();
            }
            else {
                throw new NoElementException("the car not found") ;
            }
        }else {
            throw new NoElementException("the car agency not found") ;
        }
    }
}
