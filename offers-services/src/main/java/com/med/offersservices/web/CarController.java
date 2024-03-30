package com.med.offersservices.web;

import com.med.offersservices.entity.Car;
import com.med.offersservices.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {
    CarService carService ;
    public CarController(CarService carService) {
        this.carService = carService ;
    }
    @GetMapping("/{id}")
    public Car getCarById(@PathVariable int id) {
        return carService.getCarById(id) ;
    }
}
