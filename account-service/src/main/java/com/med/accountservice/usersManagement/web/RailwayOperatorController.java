package com.med.accountservice.usersManagement.web;

import com.med.accountservice.usersManagement.service.RailwayOperatorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/railwaysOperators")
@AllArgsConstructor
public class RailwayOperatorController {
    private RailwayOperatorService railwayOperatorService ;
}
