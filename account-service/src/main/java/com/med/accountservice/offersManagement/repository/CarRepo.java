package com.med.accountservice.offersManagement.repository;

import com.med.accountservice.offersManagement.entity.Car;
import com.med.accountservice.stationsManagement.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepo extends JpaRepository<Car , Integer > {
    public List<Car> findAllByAvailableInAndNumberOfSeats(Airport airport , int nbSeats) ;
}
