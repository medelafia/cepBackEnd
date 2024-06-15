package com.med.accountservice.usersManagement.service;

import com.med.accountservice.offersManagement.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BasicService<E extends Offer, ID> {
    private JpaRepository<E , ID> repository;
    public E saveEntity(E e) {
        return repository.save(e) ;
    }
}
