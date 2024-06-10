package com.med.accountservice.usersManagement.entity;


import com.med.accountservice.offersManagement.entity.Flight;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Airline extends Provider {
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Flight> flights ;
}
