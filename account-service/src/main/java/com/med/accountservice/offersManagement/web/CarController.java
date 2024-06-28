package com.med.accountservice.offersManagement.web;
import com.med.accountservice.offersManagement.entity.Car;
import com.med.accountservice.offersManagement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/offer/cars")
@CrossOrigin("http://localhost:5173")
public class CarController {
    @Autowired
    private CarService carService ;
    @GetMapping("/")
    public List<Car> findAllCars(@RequestParam int airportId , @RequestParam int nbSeats ) {
        return carService.getAllCars(airportId , nbSeats );
    }
    @PostMapping("/setAvailable")
    public Car setAvailable(@RequestParam int id){
        return carService.setAvailable(id) ;
    }
    @GetMapping("/{id}/isAvailable")
    public boolean checkAvailable(@PathVariable int id) {
        return carService.checkAvailable(id) ;
    }
    @GetMapping("/{id}")
    public Car getCarById(@PathVariable int id) {
        return carService.getCarById(id) ;
    }
}
