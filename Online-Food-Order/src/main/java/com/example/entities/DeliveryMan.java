package com.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "DeliveryMan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryMan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deliveryManId;

    private String username;

    private boolean isAvailable;
}
