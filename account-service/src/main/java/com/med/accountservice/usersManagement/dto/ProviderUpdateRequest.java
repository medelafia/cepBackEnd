package com.med.accountservice.usersManagement.dto;

import jakarta.annotation.Nonnull;
import lombok.*;
import org.springframework.web.service.annotation.GetExchange;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class ProviderUpdateRequest {
    private String name ;
    private String webSite ;
    private String fax ;
    private String address  ;
}
