package com.med.otherservices.services;

import com.med.otherservices.entity.Country;
import com.med.otherservices.repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepo countryRepo ;
    public List<Country> getAllCountries() {
        return countryRepo.findAll() ;
    }

}
