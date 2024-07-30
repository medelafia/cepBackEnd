package com.med.accountservice.usersManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    public CarsAgency(Provider provider) {
        super(provider);
    }
    @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL , orphanRemoval = true)
    @JsonIgnore
    private List<Car> cars ;
    public List<Car> createNewCar(Car car) {
        this.cars.add(car) ;
        return this.cars ;
    }
}
