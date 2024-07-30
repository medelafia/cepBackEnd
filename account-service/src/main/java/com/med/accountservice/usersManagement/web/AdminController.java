package com.med.accountservice.usersManagement.web;

import com.med.accountservice.messagesManagement.entity.Message;
import com.med.accountservice.stationsManagement.entity.Airport;
import com.med.accountservice.stationsManagement.entity.Gate;
import com.med.accountservice.stationsManagement.entity.TrainStation;
import com.med.accountservice.stationsManagement.service.GateService;
import com.med.accountservice.usersManagement.dto.*;
import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.entity.Costumer;
import com.med.accountservice.usersManagement.service.AdminService;
import lombok.Getter;
import org.aspectj.lang.annotation.AfterReturning;
import org.eclipse.angus.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:5173")
public class AdminController {
    @Autowired
    private AdminService adminService ;
    @Autowired
    private GateService gateService ;
    @GetMapping("/gates/")
    public List<Gate> getAllGates() {
        return gateService.getAllGates() ;
    }
    @PostMapping("/gates/{id}")
    public void deleteGate(@PathVariable int id) {
        gateService.deleteGate(id) ;
    }
    @PostMapping("/trainStations/")
    public Gate addTrainTravel(@RequestBody TrainStation trainStation) {
        return adminService.addTrainStation(trainStation) ;
    }
    @PostMapping("/airports/")
    public Gate addAirport(@RequestBody Airport airport) {
        return adminService.addAirport(airport);
    }
    @PostMapping("/user")
    public void createUser(@RequestBody Account account) {
        adminService.createUser(account) ;
    }
    @PostMapping("/user/{id}")
    public void deleteUser(@PathVariable int id) {
        adminService.deleteUser(id);
    }
    @GetMapping("/user")
    public List<AccountResponse> getAllUsers() {
        return adminService.getAllUsers() ;
    }
    @GetMapping("/stats")
    public PlateFormStat getStats() {
        return new PlateFormStat();
    }
    @GetMapping("/messages")
    public List<Message> getAllMessages() {
        return adminService.getAllMessages();
    }
    @GetMapping("/messages/new")
    public List<Message> getNewMessages(){
        return adminService.getNewMessages() ;
    }
    @GetMapping("/messages/unread")
    public List<Message> getUnreadMessage() {
        return adminService.getUnreadMessages() ;
    }
}
