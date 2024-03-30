package com.med.usersservices.repository;

import com.med.usersservices.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client  , Integer> {
    public Client getClientById(int id) ;
}
