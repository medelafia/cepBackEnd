package com.med.offersservices.repositry;

import com.med.offersservices.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepo extends JpaRepository<Flight , Integer> {
    public List<Flight> findAllByAirlineId(int id) ;
}
