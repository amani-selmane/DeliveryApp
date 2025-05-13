package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.payloads.ItemPayload;
import com.example.service.ItemService;

import java.util.List;

@RestController // Ce contrôleur expose des services REST (API)
@RequestMapping("/items") // Toutes les routes commencent par /items
public class ItemController {

    @Autowired
    private ItemService itemService; // Injection du service métier

    @GetMapping // GET /items
    public ResponseEntity<List<ItemPayload>> getAllItems() {
        List<ItemPayload> items = itemService.getAllItems(); // Récupère tous les items
        return new ResponseEntity<>(items, HttpStatus.OK); // 200 OK
    }

    @GetMapping("/{itemId}") // GET /items/{id}
    public ResponseEntity<ItemPayload> getItemById(@PathVariable int itemId) {
        ItemPayload item = itemService.getItemById(itemId); // Cherche l’item par ID
        if (item != null) {
            return new ResponseEntity<>(item, HttpStatus.OK); // 200 OK si trouvé
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 si non trouvé
        }
    }

    @PostMapping // POST /items
    public ResponseEntity<ItemPayload> createItem(@RequestBody ItemPayload itemPayload) {
        ItemPayload createdItem = itemService.createItem(itemPayload); // Crée un nouvel item
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED); // 201 Created
    }

    @DeleteMapping("/{itemId}") // DELETE /items/{id}
    public ResponseEntity<Void> deleteItem(@PathVariable int itemId) {
        itemService.deleteItem(itemId); // Supprime l’item
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
    }
}
