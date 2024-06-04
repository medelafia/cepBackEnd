package com.med.accountservice.stationsManagement.web;

import com.med.accountservice.stationsManagement.entity.Gate;
import com.med.accountservice.stationsManagement.service.GateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gates")
public class GatesController {
    private GateService gateService ;
    public GatesController(GateService gateService) {
        this.gateService = gateService ;
    }
    @GetMapping("/")
    public List<Gate> getAllGates() {
        return gateService.getAllGates() ;
    }
}
