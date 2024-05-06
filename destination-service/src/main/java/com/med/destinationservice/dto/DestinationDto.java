package com.med.destinationservice.dto;

import com.med.destinationservice.enums.DestinationType;
import jakarta.annotation.Nonnull;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Builder @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class DestinationDto {
    private String name ;
    private String address ;
    private String country ;
    private String city ;
    private DestinationType destinationType ;
}
