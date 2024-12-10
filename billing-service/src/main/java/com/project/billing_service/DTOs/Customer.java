package com.project.billing_service.DTOs;


import lombok.*;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Customer {
    private Long id;
    private String name;
    private String email;
}
