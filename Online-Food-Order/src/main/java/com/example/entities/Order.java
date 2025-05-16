package com.example.entities;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Orders")
@Data // Lombok génère les getters, setters, toString, equals, hashCode
@NoArgsConstructor // Constructeur sans arguments
@AllArgsConstructor // Constructeur avec tous les champs
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "deliverymanId")
    private DeliveryMan dm;

    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    private double totalAmount;
    private String orderStatus;
    private Date orderDate;
}
