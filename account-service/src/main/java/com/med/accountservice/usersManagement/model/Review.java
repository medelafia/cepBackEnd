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
        private String title ;
        private int score ;
        private Date date ;
        private int providerId ;
        private int clientId ;
}
