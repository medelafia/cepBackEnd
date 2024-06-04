package com.med.accountservice.usersManagement.model;

import com.med.accountservice.enums.ReviewFor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Review {
        private int id ;
        private String content ;
        private int score ;
        private Date date ;
        private ReviewFor reviewFor ;
        private int providerId ;
}
