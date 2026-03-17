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
    private final ProductRepository repository;


    // TODO: Constructor that takes ProductRepository as parameter (constructor injection) 
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    /**
     * Get all products.
     */
    public List<Product> getAllProducts() {
        // TODO: Delegate to repository
       return repository.findAll();
    }

    /**
     * Get a product by ID.
     * Returns Optional<Product> — empty if not found.
     */
    public Optional<Product> getProductById(Long id) {
        // TODO: Delegate to repository
        // checks if product exists by calling existsById() method
       if(repository.existsById(id)) {
            return repository.findById(id);
       } else {
        // not found - return empty optional
            return Optional.empty();
       }

    }

    /**
     * Create a new product.
     * @return the saved product (with generated ID)
     */
    public Product createProduct(Product product) {
        // TODO: Delegate to repository
        // saves to the repository and returns the saved product
        repository.save(product);
        return product;
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
        // finds the existing product by ID using the repository
        Optional<Product> existingProdOpt = repository.findById(id);
        // if found, update its field and save
        if(existingProdOpt.isPresent()) {
            Product existingProd = existingProdOpt.get();
            existingProd.setName(updated.getName());
            existingProd.setCategory(updated.getCategory());
            existingProd.setPrice(updated.getPrice());
            existingProd.setCategory(updated.getCategory());
            existingProd.setQuantity(updated.getQuantity());
            repository.save(existingProd);
            // return product wrapped in Optional
            return Optional.of(existingProd);
        } else {
            // return empty
            return Optional.empty();
        }
    }

    /**
     * Delete a product by ID.
     * @return true if deleted, false if not found
     */
    public boolean deleteProduct(Long id) {
        // TODO: Delegate to repository
       Optional<Product> existingProdOpt = repository.findById(id);
         if(existingProdOpt.isPresent()) {
            repository.deleteById(id);
            return true;
         } else {
            return false;
         }
    }

    public List<Product> searchProductsByKeyword(String keyword) {
        return repository.findByNameContaining(keyword);

    }

    public List<Product> searchByCategory(String category) {
        return repository.findByCategory(category);
    }
}
