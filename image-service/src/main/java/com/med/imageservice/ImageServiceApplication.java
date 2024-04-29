package com.med.imageservice;

import com.cloudinary.Cloudinary;
import com.med.imageservice.entity.Image;
import com.med.imageservice.service.ImageServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ImageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageServiceApplication.class, args);
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

}
