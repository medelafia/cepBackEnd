package com.med.accountservice.entity;

import com.med.accountservice.model.Car;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@AllArgsConstructor @Getter @Setter @NoArgsConstructor
@SuperBuilder
public class CarsAgency extends Provider {
    @Transient
    private List<Car> cars ;
}
