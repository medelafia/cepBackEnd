package com.med.accountservice.offersManagement.service;


import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.imagesManagement.service.ImageService;
import com.med.accountservice.offersManagement.entity.Destination;
import com.med.accountservice.offersManagement.repository.DestinationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DestinationService {
    private DestinationRepo destinationRepo ;
    private ImageService imageService ;
    public DestinationService(DestinationRepo destinationRepo , ImageService imageService ) {
        this.destinationRepo = destinationRepo ;
        this.imageService = imageService ;
    }
    public Destination getDestinationById(int id) {
        return destinationRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("destination not found") ;
        });
    }
    @Transactional
    public Destination addDestination(Destination destination) {
        return destinationRepo.save(destination) ;
    }
    @Transactional
    public void deleteDestination(int id) {
        destinationRepo.deleteById(id);
    }
    @Transactional
    public Image addImageToDestination(MultipartFile multipartFile ,int id) {
        Image image = imageService.updloadImage(multipartFile) ;
        Destination destination = destinationRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("the destination not found") ;
        }) ;
        destination.getImages().add(image) ;
        return image ;
    }
}
