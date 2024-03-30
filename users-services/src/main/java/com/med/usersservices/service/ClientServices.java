package com.med.usersservices.service;

import com.med.usersservices.entity.Client;
import com.med.usersservices.repository.ClientRepo;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServices {
    @Autowired
    ClientRepo clientRepo ;
    public Client getClientById(int id) {
        return clientRepo.getClientById(id);
    }
    public Client saveClient(Client client) {
        return clientRepo.save(client) ;
    }
    public List<Client> getAllClients() {
        return clientRepo.findAll() ;
    }
    public void deleteClientById(int id) {
        clientRepo.deleteById(id);
    }
}
