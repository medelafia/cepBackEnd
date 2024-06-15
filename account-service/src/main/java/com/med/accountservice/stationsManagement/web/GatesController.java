package com.med.accountservice.stationsManagement.web;

import com.med.accountservice.stationsManagement.entity.Airport;
import com.med.accountservice.stationsManagement.entity.Gate;
import com.med.accountservice.stationsManagement.entity.TrainStation;
import com.med.accountservice.stationsManagement.service.GateService;
import com.med.accountservice.stationsManagement.service.TrainStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gates")
@CrossOrigin("http://localhost:5173")
public class GatesController {
    @Autowired
    private GateService gateService ;
    @GetMapping("/")
    public List<Gate> getAllGates() {
        return gateService.getAllGates() ;
    }
    @PostMapping("/trainStations/")
    public Gate addTrainTravel(@RequestBody TrainStation trainStation) {
        return gateService.addGate(trainStation) ;
    }
    @PostMapping("/airports/")
    public Gate addAirport(@RequestBody  Airport airport) {
        return gateService.addGate(airport);
    }
    @GetMapping("/airports/")
    public List<Airport> getAllAirports() {
        return gateService.getAllAirports() ;
    }
    @GetMapping("/trainStations/")
    public List<TrainStation> getAllTrainStations(){
        return gateService.getAllTrainStations() ;
    }
    @PostMapping("/{id}")
    public void deleteGate(@PathVariable String id) {
        gateService.deleteGate(id);
    }
}
