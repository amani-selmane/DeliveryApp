package com.example.entities;

import java.util.Date;

import jakarta.persistence.*;

// Cette annotation indique que cette classe est une entité JPA (table dans la base de données)
@Entity
@Table(name = "Delivery") // Nom de la table correspondante dans la base de données
public class Delivery {

    @Id // Clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrémentation
    private int deliveryId;

    // Relation ManyToOne avec la table Order : une livraison concerne une commande
    @ManyToOne
    @JoinColumn(name = "orderId") // Nom de la colonne de jointure dans la table Delivery
    private Order order;

    // ID de l’employé chargé de la livraison
    @Column(name = "deliveryExecutiveId")
    private int deliveryExecutiveId;

    // Date et heure estimées pour la livraison
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "estimatedDeliveryTime")
    private Date estimatedDeliveryTime;

    // Statut de la livraison (ex: "en cours", "livrée", "annulée", etc.)
    @Column(name = "deliveryStatus")
    private String deliveryStatus;

    // ----- GETTERS & SETTERS -----
    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getDeliveryExecutiveId() {
        return deliveryExecutiveId;
    }

    public void setDeliveryExecutiveId(int deliveryExecutiveId) {
        this.deliveryExecutiveId = deliveryExecutiveId;
    }

    public Date getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(Date estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    // Affichage utile pour les logs ou le débogage
    @Override
    public String toString() {
        return "Delivery [deliveryId=" + deliveryId +
               ", order=" + order +
               ", deliveryExecutiveId=" + deliveryExecutiveId +
               ", estimatedDeliveryTime=" + estimatedDeliveryTime +
               ", deliveryStatus=" + deliveryStatus + "]";
    }
}

