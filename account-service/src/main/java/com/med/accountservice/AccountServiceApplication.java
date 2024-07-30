package com.med.accountservice;

import com.cloudinary.Cloudinary;
import com.med.accountservice.enums.ProviderType;
import com.med.accountservice.usersManagement.dto.ProviderRequest;
import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.entity.Admin;
import com.med.accountservice.usersManagement.entity.Provider;
import com.med.accountservice.usersManagement.service.AccountService;
import com.med.accountservice.usersManagement.service.ProviderService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.impl.DefaultJwtBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
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
    public CommandLineRunner start(
            AccountService accountService
    ) {
        return ar -> {
            accountService.register(Admin.builder()
                    .registerByGoogle(false)
                    .emailVerified(false)
                    .password("admin")
                    .username("admin")
                    .email("admin@gmail.com")
                    .build());
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
