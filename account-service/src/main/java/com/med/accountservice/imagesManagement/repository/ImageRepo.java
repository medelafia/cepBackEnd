package com.med.accountservice.imagesManagement.repository;
import com.med.accountservice.imagesManagement.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ImageRepo extends JpaRepository<Image , Integer> {
}
