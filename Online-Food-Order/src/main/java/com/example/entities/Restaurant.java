package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Indique que cette classe correspond à une table dans la base de données
@Table(name = "Restaurant") // Nom de la table dans la base de données
public class Restaurant {

	@Id // Clé primaire de la table
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrémentation de l'ID
	private int restaurantId; // Identifiant unique du restaurant

	private String name; // Nom du restaurant
	private String location; // Emplacement (adresse ou ville)
	private String cuisineType; // Type de cuisine (ex: italienne, asiatique...)
	private double rating; // Note moyenne du restaurant

	// Getters et Setters pour chaque attribut
	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	// Affiche les informations du restaurant sous forme de texte
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", location=" + location
				+ ", cuisineType=" + cuisineType + ", rating=" + rating + "]";
	}

}

