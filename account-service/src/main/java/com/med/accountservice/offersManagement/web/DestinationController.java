package com.med.accountservice.offersManagement.web;


import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.offersManagement.entity.Destination;
import com.med.accountservice.offersManagement.service.DestinationService;
import lombok.AllArgsConstructor;
import org.hibernate.bytecode.internal.bytebuddy.PassThroughInterceptor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/destinations")
@AllArgsConstructor
public class DestinationController {
    private DestinationService destinationService ;
    @GetMapping("/{id}")
    public Destination getDestinationById(@PathVariable  int id) {
        return destinationService.getDestinationById(id);
    }
    @PostMapping("/")
    public Destination addDestination(Destination destination){
        return destinationService.addDestination(destination) ;
    }
    @PostMapping("/{id}")
    public void deleteDestination(@PathVariable int id) {
        destinationService.deleteDestination(id);
    }
    @PostMapping("/addImage")
    public Image addImageToDestination(MultipartFile multipartFile , int id) {
        return destinationService.addImageToDestination(multipartFile , id) ;
    }
}
