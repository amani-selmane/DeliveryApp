package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.payloads.DeliveryPayload;
import com.example.service.DeliveryService;

import java.util.List;

@RestController // Indique que cette classe est un contrôleur REST
@RequestMapping("/deliveries") // URL de base pour toutes les méthodes
public class DeliveryController {

    @Autowired // Injection automatique du service
    private DeliveryService deliveryService;

    @GetMapping // GET /deliveries : récupère toutes les livraisons
    public ResponseEntity<List<DeliveryPayload>> getAllDeliveries() {
        List<DeliveryPayload> deliveries = deliveryService.getAllDeliveries();
        return ResponseEntity.ok(deliveries); // 200 OK avec la liste
    }

    @GetMapping("/{deliveryId}") // GET /deliveries/{id} : récupère une livraison par ID
    public ResponseEntity<DeliveryPayload> getDeliveryById(@PathVariable int deliveryId) {
        DeliveryPayload delivery = deliveryService.getDeliveryById(deliveryId);
        if (delivery != null) {
            return ResponseEntity.ok(delivery); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping // POST /deliveries : ajoute une nouvelle livraison
    public ResponseEntity<DeliveryPayload> createDelivery(@RequestBody DeliveryPayload deliveryPayload) {
        DeliveryPayload createdDelivery = deliveryService.createDelivery(deliveryPayload);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDelivery); // 201 Created
    }

    @DeleteMapping("/{deliveryId}") // DELETE /deliveries/{id} : supprime une livraison
    public ResponseEntity<Void> deleteDelivery(@PathVariable int deliveryId) {
        deliveryService.deleteDelivery(deliveryId);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
