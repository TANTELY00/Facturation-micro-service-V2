package com.project.inventorys_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class Product implements Serializable {
    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
}
