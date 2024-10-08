package com.example.Alten_SQL.service;

//import com.example.Alten_SQL.AltenApplication;
import com.example.Alten_SQL.model.Product;
import com.example.Alten_SQL.repository.ProductRepository; //call the repository interface
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepository; // Wires the repository

    // GET - Retrieve all products from the repositorry
    public List<Product> getAllProducts() throws IOException
    {
        return productRepository.findAll();  // Fetches all products from the database thanks to the interface ProductRepository
    }

    // GET - Retrieve details for 1 product
    public Optional<Product> getProduct (UUID productId) //Optional because we can eventually not find it
    {
        return productRepository.findById(productId);
    }

    // POST - Add 1 product from the body
    public Product addProduct (Product product_to_add) throws IOException
    {
        //Check the inventoryStatus
        checkstatus(product_to_add);

        //Generate an id for product_to_add
        product_to_add.setId(UUID.randomUUID());

        // Save the product to the repository (database)
        return productRepository.save(product_to_add);

    }

    // PATCH - Update 1 product from the body and id
    public Product updateProduct(UUID productId, Product product_newdatas) throws IOException {

        // Get the existing product throww error if not foud
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));

        // Directly set the new data
        existingProduct.setCode(product_newdatas.getCode());
        existingProduct.setName(product_newdatas.getName());
        existingProduct.setDescription(product_newdatas.getDescription());
        existingProduct.setImage(product_newdatas.getImage());
        existingProduct.setCategory(product_newdatas.getCategory());
        existingProduct.setPrice(product_newdatas.getPrice());
        existingProduct.setQuantity(product_newdatas.getQuantity());
        existingProduct.setInternalReference(product_newdatas.getInternalReference());
        existingProduct.setShellId(product_newdatas.getShellId());
        existingProduct.setInventoryStatus(product_newdatas.getInventoryStatus());
        existingProduct.setRating(product_newdatas.getRating());
        existingProduct.setCreatedAt(product_newdatas.getCreatedAt());
        existingProduct.setUpdatedAt(product_newdatas.getUpdatedAt());

        // Update fields if the data is provided
        // Should I check that with the DTO instead?? Maybe the if aren't necessary
//        if (product_newdatas.getCode() != null)
//        {
//            existingProduct.setCode(product_newdatas.getCode());
//        }
//        if (product_newdatas.getName() != null)
//        {
//            existingProduct.setName(product_newdatas.getName());
//        }
//        if (product_newdatas.getDescription() != null)
//        {
//            existingProduct.setDescription(product_newdatas.getDescription());
//        }
//        if (product_newdatas.getImage() != null)
//        {
//            existingProduct.setImage(product_newdatas.getImage());
//        }
//        if (product_newdatas.getCategory() != null)
//        {
//            existingProduct.setCategory(product_newdatas.getCategory());
//        }
//        if (product_newdatas.getPrice() != null)
//        {
//            existingProduct.setPrice(product_newdatas.getPrice());
//        }
//        if (product_newdatas.getQuantity() != null)
//        {
//            existingProduct.setQuantity(product_newdatas.getQuantity());
//        }
//        if (product_newdatas.getInternalReference() != null)
//        {
//            existingProduct.setInternalReference(product_newdatas.getInternalReference());
//        }
//        if (product_newdatas.getShellId() != null)
//        {
//            existingProduct.setShellId(product_newdatas.getShellId());
//        }
//        if (product_newdatas.getInventoryStatus() != null)
//        {
//            existingProduct.setInventoryStatus(product_newdatas.getInventoryStatus());
//        }
//        if (product_newdatas.getRating() != null)
//        {
//            existingProduct.setRating(product_newdatas.getRating());
//        }
//        if (product_newdatas.getCreatedAt() != null)
//        {
//            existingProduct.setCreatedAt(product_newdatas.getCreatedAt());
//        }
//        if (product_newdatas.getUpdatedAt() != null)
//        {
//            existingProduct.setUpdatedAt(product_newdatas.getUpdatedAt());
//        }

        // Save the updated product back to the repository
        return productRepository.save(existingProduct);
    }

    // DELETE - Delete 1 product, no return needed so it's void
    public void deleteProduct (UUID productId) throws IOException
    {
        // Check if the product exists
        if (!productRepository.existsById(productId))
        {
            throw new EntityNotFoundException("Product not found with id: " + productId);
        }

        // Delete the product
        productRepository.deleteById(productId);

    }

    public void checkstatus (Product product_to_add) throws IOException
    {
        if (!product_to_add.getInventoryStatus().equals("INSTOCK") && !product_to_add.getInventoryStatus().equals("LOWSTOCK") && !product_to_add.getInventoryStatus().equals("OUTOFSTOCK")) {

            throw new IOException("The value of inventoryStatus should be INSTOCK, LOWSTOCK, or OUTOFSTOCK");
        }
    }


}
