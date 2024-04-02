package com.med.offersservices.repositry;

import com.med.offersservices.entity.OrganizedTravel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizedTravelRepo extends JpaRepository<OrganizedTravel , Integer> {
    public List<OrganizedTravel> findAllByTravelAgencyId(int id) ;
}
