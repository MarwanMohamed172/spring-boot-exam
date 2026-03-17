package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * ProductRepository — in-memory data store for products.
 * Uses an ArrayList to store products and a counter to generate IDs.
 *
 * YOUR TASK (Part A):
 *   Implement all 5 methods below.
 *
 * IMPORTANT: When saving a NEW product (id is null), assign it a new ID
 * using the nextId counter. When saving an EXISTING product (id is not null),
 * find and replace it in the list.
 */
@Repository
public class ProductRepository {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    /**
     * Return all products.
     */
    public List<Product> findAll() {
        // TODO: Return the full list of products
        
        // returns full list of products
        return products;
    }

    /**
     * Find a product by its ID.
     * Loop through the list and return the matching product wrapped in Optional.
     * Return Optional.empty() if not found.
     *
     * Hint: use Optional.of(product) to wrap a found product.
     */
    public Optional<Product> findById(Long id) {
        // TODO: Loop through products, find matching ID

        // loops through product list
        for(Product product : products) {
            // checks if product ID matches the entered ID
            if(product.getId().equals(id)) {
                // return the product
                return Optional.of(product);
            }
        }

        return Optional.empty();
    }

    /**
     * Save a product.
     * - If the product's ID is null → assign a new ID (nextId++) and add to the list
     * - If the product's ID is NOT null → find the existing product and replace it
     *
     * @return the saved product (with ID assigned if new)
     */
    public Product save(Product product) {
        // TODO: Implement save logic for both new and existing products
        // checks if the product ID is null
        if(product.getId() == null) {
            // increment nextId and assign it to the new product
            product.setId(nextId++);
            // add it to the products list
            products.add(product);
        } else {
            // iterate through the products list
            for(int i = 0; i < products.size(); i++) {
                // checks if the product ID matches the ID of the product being saved
                if(products.get(i).getId().equals(product.getId())) {
                    // replace existing with new product
                    products.set(i, product);
                    break;
                }

            }
        }
        return product;
    }

    /**
     * Delete a product by ID.
     * Remove it from the list.
     *
     * @return true if found and deleted, false if not found
     */
    public boolean deleteById(Long id) {
        // TODO: Find and remove the product with matching ID
        // loop through the products list
        for(int i = 0; i < products.size(); i++) {
            // checks if the product ID matches the entered ID
            if(products.get(i).getId().equals(id)){
                // removes it from the products list
                products.remove(i);
                return true;
            }
        }

        return false;
    }

    /**
     * Check if a product with the given ID exists.
     */
    public boolean existsById(Long id) {
        // TODO: Return true if a product with this ID exists in the list
        // loop through the products list
        for(int i = 0; i < products.size(); i++) {
            if(products.get(i).getId().equals(id)) {
                // returns true if a product with same ID is found
                return true;
            }
        }

        return false;
    }

    public List<Product> findByNameContaining(String keyword) {
        List<Product> result = new ArrayList<>();

        for(Product product : products) {
            if(product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(product);
            }
        }

        return result;
    }

    
    public List<Product> findByCategory(String category) {
        List<Product> result = new ArrayList<>();

        for(Product product : products) {
            if(product.getCategory().equalsIgnoreCase(category)) {
                result.add(product);
            }
        }
        return result;
    }

}
