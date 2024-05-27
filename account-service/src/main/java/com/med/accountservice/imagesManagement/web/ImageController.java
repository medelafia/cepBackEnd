package com.med.accountservice.imagesManagement.web;

import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.imagesManagement.service.ImageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/images/")
public class ImageController {
    private ImageService imageService ;
    public ImageController(ImageService imageService) {
        this.imageService = imageService ;
    }

    public Image upload(MultipartFile multipartFile) {
        return imageService.updloadImage(multipartFile) ;
    }
    @GetMapping("/{id}")
    public Image getImageById(@PathVariable int id) {
        return imageService.getImageById(id) ;
    }
    @GetMapping("/")
    public List<Image> getAllImagesByIds(List<Integer> ids) {
        return imageService.findImagesByIds(ids) ;
    }
}
