package com.med.accountservice.offersManagement.web;
import com.med.accountservice.offersManagement.entity.Car;
import com.med.accountservice.offersManagement.service.BasicService;
import com.med.accountservice.offersManagement.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private CarService carService ;
    private BasicService<Car , Integer> basicService ;
    public CarController(CarService carService ) {
        this.carService = carService ;
    }
    @GetMapping("/")
    public List<Car> findAllCars() {
        return basicService.findAll() ;
    }

}
