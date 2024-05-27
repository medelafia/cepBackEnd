package com.med.accountservice.offersManagement.repository;

import com.med.accountservice.offersManagement.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car , Integer > {

}
