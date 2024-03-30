package com.med.imageservice.service;

import com.med.imageservice.entity.Image;
import com.med.imageservice.repository.ImageRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServices {
    ImageRepo imageRepo ;
    public ImageServices(ImageRepo imageRepo) {
        this.imageRepo = imageRepo ;
    }
    public Image getImageById(int id)  {
        return imageRepo.findById(id).orElseThrow();
    }
    public List<Image> getImagesById(List<Integer> ids){
        return imageRepo.findAllById(ids) ;
    }
    public Image addImage(Image image) {
        return imageRepo.save(image) ;
    }
}
