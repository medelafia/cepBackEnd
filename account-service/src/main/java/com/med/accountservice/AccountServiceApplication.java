package com.med.accountservice;

import com.cloudinary.Cloudinary;
import com.med.accountservice.enums.AccountType;
import com.med.accountservice.enums.DestinationType;
import com.med.accountservice.enums.ProviderType;
import com.med.accountservice.offersManagement.entity.Destination;
import com.med.accountservice.offersManagement.repository.DestinationRepo;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.impl.DefaultJwtBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    //@Bean
    public CommandLineRunner start(DestinationRepo destinationRepo ) {
        return ar -> {
            destinationRepo.save(Destination.builder()
                            .name("lota hammam")
                            .country("maroc")
                            .description("this amazing city")
                            .destinationType(DestinationType.CULTURAL_AREAS)
                            .city("chefchouen")
                    .build()) ;
            destinationRepo.save(Destination.builder()
                    .name("tallasmtan")
                    .country("maroc")
                    .description("this amazing city")
                    .destinationType(DestinationType.CULTURAL_AREAS)
                    .city("chefchouen")
                    .build()) ;
            destinationRepo.save(Destination.builder()
                    .name("lota hammam")
                    .country("maroc")
                    .description("this amazing city")
                    .destinationType(DestinationType.CULTURAL_AREAS)
                    .city("chefchouen")
                    .build()) ;
            destinationRepo.save(Destination.builder()
                    .name("tallasmtan")
                    .country("maroc")
                    .description("this amazing city")
                    .destinationType(DestinationType.CULTURAL_AREAS)
                    .city("chefchouen")
                    .build()) ;
        };
    }
    @Bean
    Timestamp timestamp() {
        return new Timestamp(System.currentTimeMillis()) ;
    }
    @Bean
    JwtBuilder jwtBuilder(){
        return new DefaultJwtBuilder() ;
    }
}
