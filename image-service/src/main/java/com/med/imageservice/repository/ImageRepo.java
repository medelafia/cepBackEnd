package com.med.imageservice.repository;

import com.med.imageservice.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<Image , Integer> {
}
