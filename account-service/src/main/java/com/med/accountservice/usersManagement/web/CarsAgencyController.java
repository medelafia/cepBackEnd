package com.med.accountservice.usersManagement.web;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.med.accountservice.offersManagement.entity.Car;
import com.med.accountservice.offersManagement.service.CarService;
import com.med.accountservice.usersManagement.service.CarsAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/carsAgencies")
@CrossOrigin("http://localhost:5173")
public class CarsAgencyController {
    @Autowired
    private CarsAgencyService carsAgencyService ;
    @Autowired
    private CarService carService ;
    @PostMapping(value = "/createCar")
    public List<Car> addNewCar(@RequestPart("image")MultipartFile image , @RequestPart("car") String carString ) throws JsonProcessingException {
        Car car = new ObjectMapper().readValue(carString , Car.class) ;
        return carsAgencyService.addCar(image , car) ;
    }
    @PostMapping("/updateCar/{carId}")
    public List<Car> updateCar(@RequestBody Car car,@PathVariable int carId ) {
        return carsAgencyService.updateCar(carId ,car) ;
    }
    @GetMapping("/cars")
    public List<Car> getAllCarsByCarsAgencyId(){
        return carsAgencyService.getAllCars();
    }
    @PostMapping("/cars/{car_id}")
    public void deleteCar(@PathVariable int car_id){
        carsAgencyService.deleteCar(car_id) ;
    }
    @GetMapping("/cars/{car_id}")
    public Car getCarById(@PathVariable int car_id) {
        return carService.getCarById(car_id) ;
    }
}
