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

    //@Bean
    CommandLineRunner commandLineRunner(AirportService airportService , TrainStationService trainStationService) {
        return args -> {
            airportService.addAirport(Airport.builder()
                            .name("casa blanca")
                            .airportType(AirportType.NATIONAL)
                            .address("casa blanca")
                            .country("morocco")
                            .city("casa blanca")
                            .emailContact("casaairport@gmail.com")
                            .nbPhoneContact("028383838")
                            .lat(29)
                            .lng(28)
                    .build()) ;
        } ;
    }
}
