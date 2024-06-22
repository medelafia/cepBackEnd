package com.med.accountservice.usersManagement.entity;


import com.med.accountservice.offersManagement.entity.Flight;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Airline extends Provider {
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Flight> flights ;
    public List<Flight> createNewFlight(Flight flight) {
        this.flights.add(flight) ;
        return flights ;
    }
    public List<Flight> deleteFlightById(int id) {
        this.flights.stream().filter((flight)->{
            return flight.getId() != id ;
        }).collect(Collectors.toList()) ;
        return flights ;
    }
}
