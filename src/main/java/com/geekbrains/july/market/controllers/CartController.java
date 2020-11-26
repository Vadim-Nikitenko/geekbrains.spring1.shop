package com.geekbrains.july.market.controllers;

import com.geekbrains.july.market.entities.Product;
import com.geekbrains.july.market.exceptions.ProductNotFoundException;
import com.geekbrains.july.market.services.Cart;
import com.geekbrains.july.market.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    private Cart cart;
    private ProductsService productsService;

    @Autowired
    public CartController(ProductsService productsService, Cart cart) {
        this.productsService = productsService;
        this.cart = cart;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return cart.getProductList();
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String addProduct(@PathVariable Long id) {
        if (!productsService.existsById(id)) {
            throw new ProductNotFoundException("Product not found, id: " + id);
        }
        Product product = productsService.findById(id);
        cart.addProduct(product);
        return "OK";
    }

    @DeleteMapping("/{id}")
    public String removeProduct(@PathVariable Long id) {
        if (!productsService.existsById(id)) {
            throw new ProductNotFoundException("Product not found, id: " + id);
        }
        cart.removeProduct(productsService.findById(id));
        return "OK";
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(ProductNotFoundException exc) {
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.NOT_FOUND);
    }

}
