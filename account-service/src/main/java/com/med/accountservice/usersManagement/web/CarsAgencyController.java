package com.med.accountservice.usersManagement.web;


import com.med.accountservice.offersManagement.entity.Car;
import com.med.accountservice.usersManagement.dto.CarRequest;
import com.med.accountservice.usersManagement.entity.CarsAgency;
import com.med.accountservice.usersManagement.service.BasicService;
import com.med.accountservice.usersManagement.service.CarsAgencyService;
import com.netflix.discovery.converters.Auto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/carsAgencies")
@CrossOrigin("http://localhost:5173")
public class CarsAgencyController {
    @Autowired
    private CarsAgencyService carsAgencyService ;
    @Autowired
    private BasicService<Car , Entity> basicService ;
    @PostMapping("/{id}/createCar")
    public List<Car> addNewCar(@RequestBody CarRequest carRequest, @PathVariable int id) {
        return carsAgencyService.addCar(id , carRequest) ;
    }
    @PostMapping("/{id}/updateCar/{carId}")
    public List<Car> updateCar(@RequestBody CarRequest carRequest, @PathVariable int id,@PathVariable int carId ) {
        return carsAgencyService.updateCar(id ,carId ,carRequest) ;
    }
    @GetMapping("/{id}/cars")
    public List<Car> getAllCarsByCarsAgencyId(@PathVariable  int id){
        return carsAgencyService.getAllCarsByCarAgencyId(id);
    }
    @PostMapping("/{id}/cars/{car_id}")
    public void deleteCar( @PathVariable int id ,@PathVariable int car_id){
        carsAgencyService.deleteCar(id , car_id) ;
    }
}
