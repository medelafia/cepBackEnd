package com.med.accountservice.imagesManagement.service;

import com.cloudinary.Cloudinary;
import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.imagesManagement.repository.ImageRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ImageService {
    private ImageRepo imageRepo ;
    private Cloudinary cloudinary ;
    public ImageService(ImageRepo imageRepo) {
        this.imageRepo = imageRepo ;
    }

    public Image updloadImage(MultipartFile multipartFile) {
        cloudinary.uploader();
        return new Image() ;
    }
    public Image getImageById(int id) {
        return imageRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("image not found") ;
        }) ;
    }
    public File toFile(MultipartFile multipartFile) {
        File file = new File(multipartFile.getOriginalFilename()) ;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(multipartFile.getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file ;
    }
    public List<Image> findImagesByIds(Iterable<Integer> ids) {
        return imageRepo.findAllById(ids) ;
    }
}
