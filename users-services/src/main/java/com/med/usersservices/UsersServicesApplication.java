package com.med.usersservices;

import com.med.usersservices.entity.Airline;
import com.med.usersservices.entity.Client;
import com.med.usersservices.service.AirlineServices;
import com.med.usersservices.service.ClientServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class UsersServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersServicesApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(AirlineServices airlineServices) {
        return args -> {
            airlineServices.registerNewAirline(Airline.builder()
                            .username("mohamed")
                            .password("med@29072003")
                            .CompanyName("royal moroc")
                            .country("maroc")
                            .email("mohamedelafia@gmail.com")
                            .tel("0658045721")
                    .build()) ;
        };
    }
}
