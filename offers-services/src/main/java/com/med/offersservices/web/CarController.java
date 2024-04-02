package com.med.offersservices.web;

import com.med.offersservices.entity.Car;
import com.med.offersservices.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    CarService carService ;
    public CarController(CarService carService) {
        this.carService = carService ;
    }
    @GetMapping("/{id}")
    public List<Car> getAllProductsByProviderId(@PathVariable int id) {
        return carService.getCarsByCarsAgencyId(id) ;
    }
    @PostMapping("/")
    public Car addNewCar(@RequestBody Car car) {
        return carService.addNewCar(car) ;
    }
    @GetMapping("/")
    public List<Car> getAllCars() {
        return carService.getAllCars() ;
    }
}
