package com.med.usersservices.repository;

import com.med.usersservices.model.Flight;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "offers-services" , url = "http://localhost:8081/flights/")
public interface FlightRepo {
    @RequestMapping(method = RequestMethod.GET , value = "/{id}")
    public List<Flight> getFlightsByProviderId(@PathVariable int id) ;
}