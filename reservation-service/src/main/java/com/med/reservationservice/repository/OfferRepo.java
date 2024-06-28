package com.med.reservationservice.repository;

import com.med.reservationservice.model.Offer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "account-service" , url = "http://localhost:8089" )
public interface OfferRepo {
    @GetMapping("/offer/cars/{id}")
    public Offer getCarById(@PathVariable  int id) ;
    @GetMapping("/offer/flights/{id}")
    public Offer getFlightById(@PathVariable  int id) ;
    @GetMapping("/offer/rooms/{id}")
    public Offer getRoomById(@PathVariable  int id) ;
    @GetMapping("/offer/organizedTravels/{id}")
    public Offer getOrganizedTravelById(@PathVariable  int id) ;
    @GetMapping("/offer/trainTravels/{id}")
    public Offer getTrainTravelById(@PathVariable  int id) ;
}
