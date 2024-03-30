package com.med.offersservices.repositry;

import com.med.offersservices.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car , Integer> {
}
