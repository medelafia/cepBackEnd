package com.med.imageservice.web;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.med.imageservice.entity.Image;
import com.med.imageservice.service.ImageServices;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/images")
public class ImageController {
    ImageServices imageServices ;
    Cloudinary cloudinary ;
    public ImageController(ImageServices imageServices , Cloudinary cloudinary) {
        this.imageServices = imageServices ;
        this.cloudinary = cloudinary ;
    }
    @GetMapping("/{id}")
    public Image getImageById(@PathVariable int id) {
        return imageServices.getImageById(id) ;
    }
    @PostMapping("/")
    public Image uploadImage(MultipartFile file) {
        File fileUploaded = convertToFile(file) ;
        try {
            Map upload = cloudinary.uploader().upload(fileUploaded, ObjectUtils.emptyMap());
            if(upload != null) {
                return imageServices.addImage(upload.get("url").toString()) ;
            }
            return null ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public File convertToFile(MultipartFile multipartFile) {
        File file = new File(multipartFile.getOriginalFilename()) ;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file) ;
            fileOutputStream.write(multipartFile.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file ;
    }
}
