package com.project.billing_service.entities;

import com.project.billing_service.DTOs.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder

public class Bill implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateBilling;
    private Long customerId;
    @OneToMany(mappedBy = "bills")
    private List<ProductItem> productItems=new ArrayList<>();
    @Transient
    private Customer customer;
}
