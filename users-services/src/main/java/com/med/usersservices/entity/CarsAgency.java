package com.med.usersservices.entity;

import com.med.usersservices.model.Car;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@AllArgsConstructor @Getter @Setter
@SuperBuilder
public class CarsAgency extends Provider{
    @Transient
    private List<Car> cars ;
}
