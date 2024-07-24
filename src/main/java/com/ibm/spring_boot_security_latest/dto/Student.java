package com.ibm.spring_boot_security_latest.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Student {
	
    private int id;
    private String name;
    private String email;
    private long phone;
    
}
