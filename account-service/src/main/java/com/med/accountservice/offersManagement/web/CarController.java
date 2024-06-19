package com.med.accountservice.offersManagement.web;
import com.med.accountservice.offersManagement.entity.Car;
import com.med.accountservice.offersManagement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@CrossOrigin("http://localhost:5173")
public class CarController {
    @Autowired
    private CarService carService ;
    @GetMapping("/")
    public List<Car> findAllCars() {
        return carService.getAllCars();
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
