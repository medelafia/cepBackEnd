package com.med.accountservice.offersManagement.web;


import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.offersManagement.entity.Destination;
import com.med.accountservice.offersManagement.service.DestinationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/destinations")
@AllArgsConstructor
@CrossOrigin("http://localhost:5173")
public class DestinationController {
    private DestinationService destinationService ;
    @GetMapping("/{id}")
    public Destination getDestinationById(@PathVariable  int id) {
        return destinationService.getDestinationById(id);
    }
    @PostMapping("/")
    public Destination addDestination(@RequestBody Destination destination){
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
    @GetMapping("/")
    public List<Destination> getAllDestination() {
        return destinationService.getAllDestinations() ;
    }
}
