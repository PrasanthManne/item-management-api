package com.item_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.item_api.model.Item;
import com.item_api.service.ItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    //  Add new item
    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@Valid @RequestBody Item item) {
        Item savedItem = itemService.addItem(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    //  Get item by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getItem(@PathVariable Long id) {
        Item item = itemService.getItemById(id);

        if (item == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Item not found");
        }
        return ResponseEntity.ok(item);
    }
}

