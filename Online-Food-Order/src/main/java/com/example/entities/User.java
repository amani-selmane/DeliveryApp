package com.example.entities;

import jakarta.persistence.*;

@Entity // Indique que cette classe est une entité JPA (correspond à une table en BDD)
@Table(name = "User") // Le nom de la table sera "User"
public class User {

    @Id // Clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrémentation de l'ID
    private int userId; // Identifiant unique de l'utilisateur

    private String username;      // Nom d'utilisateur
    private String email;         // Adresse e-mail de l'utilisateur
    private String phoneNumber;   // Numéro de téléphone
    private String address;       // Adresse postale
    private String password;      // Mot de passe

    @Enumerated(EnumType.STRING) // Stocke l'enum sous forme de texte (ex: "CLIENT")
    private Role role; // Rôle de l'utilisateur (client ou livreur)

    // Enum interne représentant les deux rôles possibles
    public enum Role {
        CLIENT,
        DELIVERY_MAN
    }

    // Getters et Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // Méthode pour afficher les informations de l'utilisateur
    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", phoneNumber="
                + phoneNumber + ", address=" + address + ", password=" + password + ", role=" + role + "]";
    }
}
