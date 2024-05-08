package com.med.accountservice.feignClient;

import com.med.accountservice.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "offers-services" , url = "http://localhost:8081/")
public interface OffersRepo {
    @RequestMapping(method = RequestMethod.GET , value = "/cars/{id}")
    public List<Car> getAllCarsByAgencyId(@PathVariable int id) ;
    @RequestMapping(method = RequestMethod.GET , value = "/flights/{id}")
    public List<Flight> getAllFlightsByAirlineId(@PathVariable int id) ;
    @RequestMapping(method = RequestMethod.GET , value = "/trainTravels/{id}")
    public List<TrainTravel> getAllTrainTravelsByAgencyId(@PathVariable int id ) ;
    @RequestMapping(method = RequestMethod.GET , value = "/organizedTravels/{id}")
    public List<OrganizedTravel> getAllOrganizeTravelsByAgencyId(@PathVariable int id) ;
    @RequestMapping(method = RequestMethod.GET , value = "/rooms/{id}")
    public List<Room> getAllRoomsByHotelId(@PathVariable int id) ;
}
