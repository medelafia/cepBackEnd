package com.med.imageservice;

import com.med.imageservice.entity.Image;
import com.med.imageservice.service.ImageServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ImageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageServiceApplication.class, args);
    }
    //@Bean
    CommandLineRunner commandLineRunner(ImageServices imageServices) {
        return args -> {
            imageServices.addImage(Image.builder()
                    .url("rbjrbjbrjrjrjbj").build());
        } ;
    }

}
