package com.med.imageservice.web;

import com.med.imageservice.entity.Image;
import com.med.imageservice.service.ImageServices;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/images")
public class ImageController {
    ImageServices imageServices ;
    public ImageController(ImageServices imageServices) {
        this.imageServices = imageServices ;
    }
    @GetMapping("/{id}")
    public Image getImageById(@PathVariable int id) {
        return imageServices.getImageById(id) ;
    }
}
