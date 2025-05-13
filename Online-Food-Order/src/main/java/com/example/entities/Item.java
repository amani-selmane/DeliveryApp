package com.example.entities;

import jakarta.persistence.*;

// Cette annotation marque la classe comme une entité JPA, c’est-à-dire une table dans la base de données
@Entity
@Table(name = "Item") // Nom de la table dans la base de données
public class Item {

    @Id // Clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrémentation de l'ID
    private int itemId;

    // Relation ManyToOne : plusieurs articles (items) peuvent être associés à une seule commande (Order)
    @ManyToOne
    @JoinColumn(name = "orderId") // Nom de la colonne de jointure dans la base de données
    private Order order;

    // Nom de l’article (par exemple, "Pizza", "Burger", etc.)
    private String name;

    // Quantité de l’article dans la commande
    private int quantity;

    // Prix unitaire de l’article
    private double price;

    // ----- GETTERS & SETTERS -----
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Méthode toString : utile pour l'affichage ou le débogage
    @Override
    public String toString() {
        return "Item [itemId=" + itemId +
               ", order=" + order +
               ", name=" + name +
               ", quantity=" + quantity +
               ", price=" + price + "]";
    }
}
