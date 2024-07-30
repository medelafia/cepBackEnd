package com.med.accountservice.usersManagement.web;

import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.reservationManagement.entity.Reservation;
import com.med.accountservice.reviewsManagement.entity.Review;
import com.med.accountservice.usersManagement.dto.ProviderResponse;
import com.med.accountservice.usersManagement.dto.ProviderUpdateRequest;
import com.med.accountservice.usersManagement.entity.*;
import com.med.accountservice.usersManagement.service.AccountService;
import com.med.accountservice.usersManagement.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/provider")
@CrossOrigin("http://localhost:5173")
public class ProviderController {
    @Autowired
    private AccountService accountService ;
    @Autowired
    private ProviderService providerService ;
    @GetMapping("/")
    public ProviderResponse getMyInfo() {
        return providerService.getProviderInfo() ;
    }
    @PostMapping("/changeLogo")
    public Provider changeLogo(MultipartFile image) {
        return providerService.changeLogo(image) ;
    }
    @PostMapping("/update")
    public Provider updateProviderInfo(@RequestBody ProviderUpdateRequest providerUpdateRequest ) {
        return providerService.updateProviderInfo(providerUpdateRequest) ;
    }
    @GetMapping("/getImages")
    public List<Image> getImages() {
        return providerService.getAllImages() ;
    }
    @PostMapping("/addImages")
    public List<Image> addImages(MultipartFile[] images) {
        return providerService.addImages(images ) ;
    }
    @PostMapping("/deleteImages")
    public void deleteImages(@RequestBody List<Integer> imagesIds ) {
        providerService.deleteImages(imagesIds ) ;
    }
    @GetMapping("/reservations")
    public List<Reservation> getAllReservation() {return providerService.getAllReservations() ;
    }
}