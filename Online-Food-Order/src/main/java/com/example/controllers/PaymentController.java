package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.payloads.PaymentPayload;
import com.example.service.PaymentService;

import java.util.List;

@RestController // Définit un contrôleur REST
@RequestMapping("/payments") // URL de base pour les paiements
public class PaymentController {

    @Autowired
    private PaymentService paymentService; // Injection du service de paiement

    @GetMapping // GET /payments
    public ResponseEntity<List<PaymentPayload>> getAllPayments() {
        // Récupère et retourne tous les paiements
        List<PaymentPayload> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments); // 200 OK
    }

    @GetMapping("/{paymentId}") // GET /payments/{id}
    public ResponseEntity<PaymentPayload> getPaymentById(@PathVariable int paymentId) {
        // Récupère un paiement par ID
        PaymentPayload payment = paymentService.getPaymentById(paymentId);
        if (payment != null) {
            return ResponseEntity.ok(payment); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping // POST /payments
    public ResponseEntity<PaymentPayload> createPayment(@RequestBody PaymentPayload paymentPayload) {
        // Crée un nouveau paiement
        PaymentPayload createdPayment = paymentService.createPayment(paymentPayload);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPayment); // 201 Created
    }

    @DeleteMapping("/{paymentId}") // DELETE /payments/{id}
    public ResponseEntity<Void> deletePayment(@PathVariable int paymentId) {
        // Supprime un paiement par ID
        paymentService.deletePayment(paymentId);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}

