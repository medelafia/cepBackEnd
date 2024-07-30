package com.med.accountservice.reservationManagement.repository;


import com.med.accountservice.reservationManagement.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentInfoRepo extends JpaRepository<PaymentInfo, String > {
    public Optional<PaymentInfo> findByProviderId(int id) ;
}
