package com.med.gateservice;

import com.med.gateservice.entity.Airport;
import com.med.gateservice.enums.AirportType;
import com.med.gateservice.service.AirportService;
import com.med.gateservice.service.TrainStationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GateServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateServiceApplication.class, args);
    }

}
