package com.med.accountservice.offersManagement.web;
import com.med.accountservice.offersManagement.dto.AvailabilityResponse;
import com.med.accountservice.offersManagement.entity.Car;
import com.med.accountservice.offersManagement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/offer/cars")
@CrossOrigin("http://localhost:5173")
public class CarController {
    @Autowired
    private CarService carService ;
    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

}
