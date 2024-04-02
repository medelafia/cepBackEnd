package com.med.offersservices.feignClient;

import com.med.offersservices.model.Airport;
import com.med.offersservices.model.TrainStation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "gate-service" , url = "http://localhost:8084/")
public interface GateRepo {
    @RequestMapping("/airports/{id}")
    public Airport getAirportById(@PathVariable int id) ;

    @RequestMapping("/trainStations/{id}")
    public TrainStation getTrainStationById(@PathVariable int id) ;
}
