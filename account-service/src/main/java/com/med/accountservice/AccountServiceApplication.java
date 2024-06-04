package com.med.accountservice;

import com.cloudinary.Cloudinary;
import com.med.accountservice.enums.AccountType;
import com.med.accountservice.enums.ProviderType;
import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.entity.Costumer;
import com.med.accountservice.usersManagement.entity.Hotel;
import com.med.accountservice.usersManagement.repository.*;
import com.med.accountservice.usersManagement.service.AccountService;
import com.med.accountservice.usersManagement.service.HotelService;
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
    public CommandLineRunner start(AccountService accountService) {
        return ar->{
            accountService.register(Account.builder()
                            .accountType(AccountType.COSTUMER)
                            .username("mohamed")
                            .password("med@29072003")
                            .email("mohamedelafia723@gmail.com")
                            .tel("0658045721")
                    .build()) ;
        };
    }
    @Bean
    Timestamp timestamp() {
        return new Timestamp(System.currentTimeMillis()) ;
    }
}
