package com.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Payment")
@Data // Génère automatiquement getters, setters, toString, equals, hashCode
@NoArgsConstructor // Génère un constructeur sans argument
@AllArgsConstructor // Génère un constructeur avec tous les champs
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    private double amount;

    @Column(name = "paymentMethod")
    private String paymentMethod;

    @Column(name = "paymentStatus")
    private String paymentStatus;
}
