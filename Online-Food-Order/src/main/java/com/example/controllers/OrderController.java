package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.payloads.OrderPayload;
import com.example.service.OrderService;

import java.util.List;

@RestController // Contrôleur REST : gère les requêtes HTTP pour les commandes
@RequestMapping("/orders") // URL de base : /orders
public class OrderController {

    @Autowired
    private OrderService orderService; // Injection du service de gestion des commandes

    @GetMapping // GET /orders
    public ResponseEntity<List<OrderPayload>> getAllOrders() {
        List<OrderPayload> orders = orderService.getAllOrders(); // Récupère toutes les commandes
        return new ResponseEntity<>(orders, HttpStatus.OK); // 200 OK
    }

    @GetMapping("/{orderId}") // GET /orders/{id}
    public ResponseEntity<OrderPayload> getOrderById(@PathVariable int orderId) {
        OrderPayload order = orderService.getOrderById(orderId); // Récupère une commande par ID
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK); // 200 OK si trouvée
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 si non trouvée
        }
    }

    @PostMapping // POST /orders
    public ResponseEntity<OrderPayload> createOrder(@RequestBody OrderPayload orderPayload) {
        OrderPayload createdOrder = orderService.createOrder(orderPayload); // Crée une commande
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED); // 201 Created
    }

    @DeleteMapping("/{orderId}") // DELETE /orders/{id}
    public ResponseEntity<Void> deleteOrder(@PathVariable int orderId) {
        orderService.deleteOrder(orderId); // Supprime une commande
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
    }
}
