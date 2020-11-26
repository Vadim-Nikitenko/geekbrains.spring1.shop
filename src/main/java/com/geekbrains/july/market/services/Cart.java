package com.geekbrains.july.market.services;

import com.geekbrains.july.market.entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {

    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }

    public List<Product> getProductList() {
        return productList;
    }

}
