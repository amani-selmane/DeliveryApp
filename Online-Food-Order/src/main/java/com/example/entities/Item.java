package com.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// Cette annotation marque la classe comme une entité JPA
@Entity
@Table(name = "Item")
@Data // Génère automatiquement getters, setters, toString, equals, hashCode
@NoArgsConstructor // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec tous les arguments
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    private String name;
    private int quantity;
    private double price;
}
