package com.med.offersservices;

import com.med.offersservices.entity.Flight;
import com.med.offersservices.service.FlightService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import java.time.Instant;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class OffersServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(OffersServicesApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(FlightService flightService) {
        return  args ->  {
            flightService.addNewFlight(Flight.builder()
                            .price(100)
                            .date(new Date())
                            .beginTime(Instant.now())
                            .arrivedTime(Instant.now())
                            .nbPlaces(100)
                            .airlineId(1)
                            .distance(2000)
                    .build());
        } ;
    }
}
