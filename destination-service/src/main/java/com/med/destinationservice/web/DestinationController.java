package com.med.destinationservice.web;

import com.med.destinationservice.dto.DestinationDto;
import com.med.destinationservice.entity.Destination;
import com.med.destinationservice.service.DestinationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinations/")
public class DestinationController {
    DestinationService destinationService ;
    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService ;
    }
    @GetMapping("/")
    public List<Destination> getAllDestinations() {
        return destinationService.getAllDestinations() ;
    }
    @GetMapping("/{country}")
    public List<Destination> getAllDestinationsByCountry(@PathVariable String country){
        return destinationService.getAllDestinationsByCountry(country) ;
    }
    @PostMapping("/")
    public Destination addNewDestination(DestinationDto destinationDto) {
        return destinationService.addNewDestination(destinationDto) ;
    }
}
