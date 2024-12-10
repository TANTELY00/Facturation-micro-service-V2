package com.project.billing_service.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.billing_service.DTOs.Product;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder

public class ProductItem implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private double unitPrice;
    private int quantity;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bills;
    @Transient
    private Product product;
}
