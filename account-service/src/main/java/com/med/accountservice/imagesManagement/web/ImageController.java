package com.med.accountservice.imagesManagement.web;

import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.imagesManagement.service.ImageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/images/")
public class ImageController {
    private ImageService imageService ;
    public ImageController(ImageService imageService) {
        this.imageService = imageService ;
    }
    @PostMapping("/")
    public Image upload(MultipartFile file) {
        return imageService.updloadImage(file) ;
    }
    @GetMapping("/{id}")
    public Image getImageById(@PathVariable int id) {
        return imageService.getImageById(id) ;
    }
    @GetMapping("/")
    public List<Image> getAllImagesByIds(List<Integer> ids) {
        return imageService.findImagesByIds(ids) ;
    }
    @PostMapping("/multiple/")
    public List<Image> uploadMultipleImages(MultipartFile[] files) {
        return  imageService.uploadImages(files);
    }

}