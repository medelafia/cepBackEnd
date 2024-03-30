package com.med.usersservices;

import com.med.usersservices.entity.Client;
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
    CommandLineRunner commandLineRunner(ClientServices clientServices) {
        return args -> {
            clientServices.saveClient(Client.builder()
                            .username("mohamed")
                            .password("med@29072003")
                            .tel("0658045721")
                            .authority("ADMIN")
                            .email("mohamedelafia@gmail.com")
                            .age(20)
                            .lastName("el afia")
                            .firstName("mohamed")
                            .sexe("man")
                    .build()) ;
        };
    }
}
