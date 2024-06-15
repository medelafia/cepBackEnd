package com.med.accountservice.offersManagement.repository;

import com.med.accountservice.offersManagement.entity.Flight;
import com.med.accountservice.stationsManagement.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface FlightRepo extends JpaRepository<Flight , Integer> {
    public List<Flight> findAllByAirlineId(int id) ;
    public List<Flight> findAllByDepartDateAndReturnDateAndFromAndTo(Date departDate , Date returnDate , Airport from, Airport to) ;
    public List<Flight> findAllByDepartDateAndFromAndTo(Date departDate , Airport from, Airport to) ;
}
