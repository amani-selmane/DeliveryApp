package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.payloads.UserPayload;
import com.example.service.DeliveryManService;

import java.util.List;

@RestController // Indique que cette classe gère des requêtes REST
@RequestMapping("/users") // Toutes les routes de ce contrôleur commenceront par /users
public class UserController {

    @Autowired
    private DeliveryManService userService; // Injection du service qui contient la logique métier

    // Endpoint pour récupérer tous les utilisateurs (GET /users)
    @GetMapping
    public ResponseEntity<List<UserPayload>> getAllUsers() {
        List<UserPayload> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK); // 200 OK avec la liste des utilisateurs
    }

    // Endpoint pour récupérer un utilisateur par son ID (GET /users/{userId})
    @GetMapping("/{userId}")
    public ResponseEntity<UserPayload> getUserById(@PathVariable int userId) {
        UserPayload user = userService.getUserById(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK); // 200 OK si l'utilisateur existe
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 si non trouvé
        }
    }

    // Endpoint pour créer un nouvel utilisateur (POST /users)
    @PostMapping
    public ResponseEntity<UserPayload> createUser(@RequestBody UserPayload userPayload) {
        UserPayload createdUser = userService.createUser(userPayload);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED); // 201 Created
    }

    // Endpoint pour supprimer un utilisateur (DELETE /users/{userId})
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content après suppression
    }
}
