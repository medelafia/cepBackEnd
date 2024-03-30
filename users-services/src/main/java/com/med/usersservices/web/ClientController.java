package com.med.usersservices.web;

import com.med.usersservices.entity.Client;
import com.med.usersservices.service.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients/")
public class ClientController {
    @Autowired
    ClientServices clientServices ;
    @GetMapping("/")
    public List<Client> getAllClients(){
        return clientServices.getAllClients() ;
    }
}
