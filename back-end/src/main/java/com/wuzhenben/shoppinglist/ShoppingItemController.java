package com.wuzhenben.shoppinglist;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/shopping-items")
public class ShoppingItemController {

    private final ShoppingItemRepository shoppingItemRepository;

    public ShoppingItemController(ShoppingItemRepository shoppingItemRepository) {
        this.shoppingItemRepository = shoppingItemRepository;
    }

    // create shopping item
    @PostMapping
    public ShoppingItem createShoppingItem(@RequestBody ShoppingItem shoppingItem) {
        return this.shoppingItemRepository.save(shoppingItem);
    }

    // get all shopping items
    @GetMapping
    public List<ShoppingItem> getAllShoppingItems() {
        return this.shoppingItemRepository.findAll();
    }

    // get shopping item by id
    @GetMapping("/{id}")
    public Optional<ShoppingItem> getShoppingItemById(@PathVariable("id") Long id) {
        return this.shoppingItemRepository.findById(id);
    }

    // update shopping item by id
    @PutMapping("/{id}")
    public Optional<ShoppingItem> updateShoppingItemById(@PathVariable("id") Long id, @RequestBody ShoppingItem shoppingItem) {
        return this.shoppingItemRepository.findById(id).map(shoppingItemToUpdate -> {
            shoppingItemToUpdate.setItem(shoppingItem.getItem());
            shoppingItemToUpdate.setPurchased(shoppingItem.getPurchased());
            return this.shoppingItemRepository.save(shoppingItemToUpdate);
        });
    }

    // delete shopping item by id
    @DeleteMapping("/{id}")
    public void deleteShoppingItemById(@PathVariable("id") Long id) {
        this.shoppingItemRepository.deleteById(id);
    }

}
