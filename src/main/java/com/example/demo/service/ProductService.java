package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ProductService — business logic layer for products.
 *
 * YOUR TASK (Part B):
 *   1. Add constructor injection for ProductRepository
 *   2. Implement all 5 methods below
 *
 * Follow the same pattern from the BookService in Day 2:
 *   - Constructor takes the repository as a parameter
 *   - Each method delegates to the repository
 */
@Service
public class ProductService {

    // TODO: Declare a private final ProductRepository field


    // TODO: Constructor that takes ProductRepository as parameter (constructor injection)


    /**
     * Get all products.
     */
    public List<Product> getAllProducts() {
        // TODO: Delegate to repository
        return null;
    }

    /**
     * Get a product by ID.
     * Returns Optional<Product> — empty if not found.
     */
    public Optional<Product> getProductById(Long id) {
        // TODO: Delegate to repository
        return Optional.empty();
    }

    /**
     * Create a new product.
     * @return the saved product (with generated ID)
     */
    public Product createProduct(Product product) {
        // TODO: Delegate to repository
        return null;
    }

    /**
     * Update an existing product.
     * Find the existing product by ID, update its fields, and save it.
     *
     * @return Optional containing the updated product, or empty if not found
     */
    public Optional<Product> updateProduct(Long id, Product updated) {
        // TODO: Find existing product by ID
        // TODO: If found, update its name, category, price, and quantity
        // TODO: Save and return the updated product
        // TODO: If not found, return Optional.empty()
        return Optional.empty();
    }

    /**
     * Delete a product by ID.
     * @return true if deleted, false if not found
     */
    public boolean deleteProduct(Long id) {
        // TODO: Delegate to repository
        return false;
    }
}
