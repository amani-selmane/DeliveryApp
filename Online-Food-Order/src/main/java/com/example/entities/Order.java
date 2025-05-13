package com.example.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity // Indique que cette classe est une entité JPA (correspond à une table dans la base de données)
@Table(name = "Orders") // Spécifie le nom de la table associée à cette entité
public class Order {

	@Id // Clé primaire de l'entité
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrémentation de l'ID (générée par la base de données)
	private int orderId;

	@ManyToOne // Relation "plusieurs commandes pour un seul utilisateur"
	@JoinColumn(name = "userId") // Colonne de jointure vers l'entité User
	private User user;

	@ManyToOne // Relation "plusieurs commandes pour un seul restaurant"
	@JoinColumn(name = "restaurantId") // Colonne de jointure vers l'entité Restaurant
	private Restaurant restaurant;

	private double totalAmount; // Montant total de la commande
	private String orderStatus; // Statut de la commande (ex : "en attente", "livrée", etc.)
	private Date orderDate; // Date à laquelle la commande a été passée

	// Getter et Setter pour orderId
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	// Getter et Setter pour user
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// Getter et Setter pour restaurant
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	// Getter et Setter pour totalAmount
	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	// Getter et Setter pour orderStatus
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	// Getter et Setter pour orderDate
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	// Méthode toString pour afficher les informations de l'objet Order
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", user=" + user + ", restaurant=" + restaurant + ", totalAmount="
				+ totalAmount + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + "]";
	}

}
