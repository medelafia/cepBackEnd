package com.med.offersservices.repositry;

import com.med.offersservices.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepo extends JpaRepository<Car , Integer> {
    public List<Car> findAllByCarAgencyId(int id) ;
}
