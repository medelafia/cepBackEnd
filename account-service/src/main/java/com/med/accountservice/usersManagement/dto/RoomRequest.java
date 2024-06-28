package com.med.accountservice.usersManagement.dto;

import com.med.accountservice.enums.RoomType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor @Getter @Setter @Builder
public class RoomRequest {
    private MultipartFile[] multipartFile ;
    private float price ;
    private int nbOfRooms ;
    @Enumerated(value = EnumType.STRING)
    private RoomType roomType ;
    private int adults ;
    private int childs ;
    private boolean available ;
    private int kingBeds ;
    private int twinsBeds ;
    private int roomNumber ;
    private boolean hasTv ;
    private boolean freeWifi  ;
    private boolean airConditioning;
}
