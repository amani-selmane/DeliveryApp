package com.example.entities;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

// Lombok annotations to reduce boilerplate
@Data // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // No-args constructor
@AllArgsConstructor // All-args constructor
@Entity
@Table(name = "Delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deliveryId;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @Column(name = "deliveryExecutiveId")
    private int deliveryExecutiveId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "estimatedDeliveryTime")
    private Date estimatedDeliveryTime;

    @Column(name = "deliveryStatus")
    private String deliveryStatus;
}
