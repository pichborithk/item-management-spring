package dev.pichborith.ItemManagement.controllers;

import dev.pichborith.ItemManagement.models.item.ItemRequest;
import dev.pichborith.ItemManagement.models.item.ItemResponse;
import dev.pichborith.ItemManagement.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ItemResponse>> getAllItems() {
        var items = itemService.getAll();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemResponse> getItemById(@PathVariable int itemId) {
        var item = itemService.getById(itemId);
        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<ItemResponse> createItem(
        @RequestBody ItemRequest request) {
        var item = itemService.add(request);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }
}
