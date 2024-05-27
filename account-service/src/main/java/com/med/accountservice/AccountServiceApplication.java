package com.med.accountservice;

import com.cloudinary.Cloudinary;
import com.med.accountservice.enums.AccountType;
import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.entity.Costumer;
import com.med.accountservice.usersManagement.repository.AccountRepo;
import com.med.accountservice.usersManagement.repository.AirlineRepo;
import com.med.accountservice.usersManagement.repository.CustomerRepo;
import com.med.accountservice.usersManagement.repository.RailwayOperatorRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableFeignClients
@CrossOrigin("http://localhost:5173")
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    public Cloudinary cloudinaryConfig() {
        Cloudinary cloudinary = null  ;
        Map config = new HashMap<>( );
        config.put("cloud_name", "dl0zud05l");
        config.put("api_secret" , "7HMFiXgY1hezq9s9ce0cXcJPM7Q") ;
        config.put("api_key","272861946647322") ;
        cloudinary = new Cloudinary(config) ;
        return cloudinary ;
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public CommandLineRunner start(AccountRepo accountRepo ,
                                   CustomerRepo customerRepo ,
                                   AirlineRepo airlineRepo ,
                                   RailwayOperatorRepo railwayOperatorRepo) {
        return ar->{
            accountRepo.save(Account.builder()
                            .tel("0658045721")
                            .email("mohamedelafia016@gmail.com")
                            .password("med@29072003")
                            .username("mohamed")
                    .build()) ;
            customerRepo.save(Costumer.builder()
                        .tel("0658045721")
                        .email("mohamedelafia016@gmail.com")
                        .password("med@29072003")
                        .username("mohamed")
                            .firstName("mohamed")
                            .lastName("elafia")
                            .gender("m")
                            .age(20)
                    .build()) ;
        } ;
    }
    @Bean
    Timestamp timestamp() {
        return new Timestamp(System.currentTimeMillis()) ;
    }
}
