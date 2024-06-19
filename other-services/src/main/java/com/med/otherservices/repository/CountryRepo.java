package com.med.otherservices.repository;

import com.med.otherservices.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country , Integer > {
}
