package com.med.accountservice.offersManagement.service;

import com.med.accountservice.offersManagement.entity.Offer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class BasicService<ENTITY extends Offer, KEY>{
    private JpaRepository<ENTITY,KEY> repository ;

    public ENTITY save(ENTITY entity) {
        return repository.save(entity) ;
    }
    public List<ENTITY> findAll() {
        return repository.findAll() ;
    }
}
