package com.med.accountservice.usersManagement.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class HotelResponse extends ProviderResponse {
    private int nbStars ;
    private String address ;
    private float longitude ;
    private float latitude ;
}
