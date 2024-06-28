package com.med.accountservice.usersManagement.dto;

import com.med.accountservice.enums.FuelType;
import com.med.accountservice.enums.StyleType;
import com.med.accountservice.enums.TransType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class CarRequest {
    public MultipartFile image ;
    private String make ;
    private String model ;
    private float price ;
    private int airportId ;
    private int seats ;
    private int doors ;
    private int bags ;
    @Enumerated(value = EnumType.STRING)
    private FuelType fuelType ;
    @Enumerated(value = EnumType.STRING)
    private TransType transType ;
    @Enumerated(value = EnumType.STRING)
    private StyleType styleType ;
    private boolean airConditioning ;
    private boolean freeCancelation ;
    private boolean available  ;
}
