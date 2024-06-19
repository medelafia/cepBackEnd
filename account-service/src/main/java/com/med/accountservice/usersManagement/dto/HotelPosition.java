package com.med.accountservice.usersManagement.dto;


import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class HotelPosition {
    private int hotelId ;
    private float lng ;
    private float lat  ;
}
