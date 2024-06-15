package com.med.accountservice.imagesManagement.service;

import com.cloudinary.Cloudinary;
import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.imagesManagement.repository.ImageRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.query.internal.ImplicitAttributeFetchMemento;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ImageService {
    private ImageRepo imageRepo ;
    private Cloudinary cloudinary ;
    public ImageService(ImageRepo imageRepo , Cloudinary cloudinary) {
        this.cloudinary = cloudinary ;
        this.imageRepo = imageRepo ;
    }

    public Image updloadImage(MultipartFile multipartFile) {
        File file = this.toFile(multipartFile) ;
        try {
            Map<String , String> map = cloudinary.uploader().upload(file, null);
            return imageRepo.save(Image.builder().url(map.get("url")).build()) ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
    public Image saveImage(String url) {
        Image image = Image.builder()
                .url(url)
                .build();
        return imageRepo.save(image) ;
    }
    public List<Image> uploadImages(MultipartFile[] files) {
        List<Image> images = new ArrayList<>() ;
        for(MultipartFile file : files) {
            images.add(updloadImage(file)) ;
        }
        return images ;
    }
}
