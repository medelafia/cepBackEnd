package com.med.accountservice.usersManagement.dto;

import com.med.accountservice.usersManagement.entity.Amenitie;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class HotelResponse extends ProviderResponse {
    private float longitude ;
    private float latitude ;
    private List<Amenitie> amenitieList ;
    private int minPrice ;
}
