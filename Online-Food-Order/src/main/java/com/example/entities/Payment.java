package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity // Indique que cette classe est une entité JPA (table dans la base de données)
@Table(name = "Payment") // Nom de la table dans la base de données
public class Payment {

	@Id // Clé primaire de la table
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Valeur auto-générée (auto-incrémentée)
	private int paymentId;

	@ManyToOne // Relation "plusieurs paiements pour une commande"
	@JoinColumn(name = "orderId") // Colonne de jointure vers la table des commandes
	private Order order;

	private double amount; // Montant du paiement

	@Column(name = "paymentMethod") // Méthode de paiement (ex: carte, cash, PayPal...)
	private String paymentMethod;

	@Column(name = "paymentStatus") // Statut du paiement (ex: payé, en attente, échoué)
	private String paymentStatus;

	// Getter et Setter pour paymentId
	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	// Getter et Setter pour order
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	// Getter et Setter pour amount
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	// Getter et Setter pour paymentMethod
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	// Getter et Setter pour paymentStatus
	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	// Méthode toString pour afficher les détails du paiement
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", order=" + order + ", amount=" + amount + ", paymentMethod="
				+ paymentMethod + ", paymentStatus=" + paymentStatus + "]";
	}

}

