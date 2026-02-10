package com.example.product_management.service;

import com.example.product_management.controller.ProductController;
import com.example.product_management.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();
    private int nextId = 4;
    public ProductService() {
        products.add(new Product(1, "Laptop", 1500));
        products.add(new Product(2, "Chuột", 20));
        products.add(new Product(3, "Bàn phím", 45));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    public Product updateProduct(int id, Product newProduct) {
        for (Product p : products) {
            if(p.getId() == id) {
                p.setName(newProduct.getName());
                p.setPrice(newProduct.getPrice());
                return p;
            }
        } return null;
    }

    public boolean deleteProduct(int id) {
        return products.removeIf(p -> p.getId() == id);
    }
}
