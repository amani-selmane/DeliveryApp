package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.payloads.RestaurantPayload;
import com.example.service.RestaurantService;

import java.util.List;

@RestController 
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService; 

    @GetMapping
    public ResponseEntity<List<RestaurantPayload>> getAllRestaurants() {
        List<RestaurantPayload> restaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK); // 200 OK avec la liste des restaurants
    }

    // Récupérer un restaurant par ID (GET /restaurants/{id})
    @GetMapping("/{restaurantId}")
    public ResponseEntity<RestaurantPayload> getRestaurantById(@PathVariable int restaurantId) {
        RestaurantPayload restaurant = restaurantService.getRestaurantById(restaurantId);
        if (restaurant != null) {
            return new ResponseEntity<>(restaurant, HttpStatus.OK); // 200 OK avec le restaurant
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 si le restaurant n'existe pas
        }
    }

    
    @PostMapping
    public ResponseEntity<RestaurantPayload> createRestaurant(@RequestBody RestaurantPayload restaurantPayload) {
        RestaurantPayload createdRestaurant = restaurantService.createRestaurant(restaurantPayload);
        return new ResponseEntity<>(createdRestaurant, HttpStatus.CREATED); // 201 Created
    }

    // Supprimer un restaurant par ID (DELETE /restaurants/{id})
    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable int restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content après suppression
    }
}
