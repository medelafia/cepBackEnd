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
    public CarController(CarService carService , BasicService basicService) {
        this.carService = carService ;
        this.basicService = basicService ;
    }
    @GetMapping("/")
    public List<Car> findAllCars() {
        return basicService.findAll() ;
    }
    @PostMapping("/")
    public Car addCar(@RequestBody Car car){
        return basicService.save(car) ;
    }
    @PostMapping("/setAvailable")
    public Car setAvailable(@RequestParam int id){
        return carService.setAvailable(id) ;
    }
    @GetMapping("/{id}")
    public boolean checkAvailable(@PathVariable int id) {
        return carService.checkAvailable(id) ;
    }
}
