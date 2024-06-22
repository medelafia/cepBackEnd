package com.med.accountservice.usersManagement.entity;

import com.med.accountservice.offersManagement.entity.Car;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @Getter @Setter @NoArgsConstructor
public class CarsAgency extends Provider{
    @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.REMOVE )
    private List<Car> cars ;
    public List<Car> createNewCar(Car car) {
        this.cars.add(car) ;
        return this.cars ;
    }
}
