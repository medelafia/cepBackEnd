package com.med.reviewsservice.dto;
import lombok.*;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class ReviewDto {
    private String content ;
    private int score ;
    private String reviewFor ;
    private int providerId ;
}
