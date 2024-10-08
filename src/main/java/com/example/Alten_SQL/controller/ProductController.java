package com.example.Alten_SQL.controller;

import com.example.Alten_SQL.controller.dto.ProductDTOOUT;
import com.example.Alten_SQL.controller.dto.ProductDTOIN;
import com.example.Alten_SQL.controller.dto.ProductMapper;
import com.example.Alten_SQL.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Alten_SQL.model.Product;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductController
{

    // Using the ProductService that handled the datas
    private final ProductService productservice;
    private final ProductMapper productmapper;

    // Make the constructor for ProjectController
    public ProductController(ProductService productservice, ProductMapper productmapper)
    {
        this.productservice = productservice;
        this.productmapper = productmapper;
    }

    @GetMapping("/products") // Map HTTP GET requests to the method right under
    @Operation(summary = "Get all products")
    @ResponseStatus(HttpStatus.OK)
    // We use Rest API so we use the url to transfer datas
    public List<ProductDTOOUT> getAllProducts () throws IOException //Return a list because loadProducts returns a List
    {
        //We return the list
        return this.productservice.getAllProducts().stream().map(ProductMapper::to_DTO_OUT).toList();
        // <we fetch all products from the ProductService and we convert them to DTO
    }

    @GetMapping ("/products/{id}") // Map HTTP GET requests to the method right under. {id} to look for the product required
    @Operation(summary = "Get one product by id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductDTOOUT> getProduct (@PathVariable("id") UUID productId) throws IOException //Return a list because loadProducts returns a List
    {
        // Get the product we want
        Optional<Product> product = productservice.getProduct(productId);

        // If the product is found, we return it with a 200
        if (product.isPresent())
        {
            // Convert a Product entity into a ProductDTOOUT
            ProductDTOOUT DTO_OUT = ProductMapper.to_DTO_OUT(product.get());

            // Return the DTO_OUT instead of product
            return new ResponseEntity<>(DTO_OUT, HttpStatus.OK);
        }
        // if the product is not found, we return a 404
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/products/add")
    @Operation(summary = "Add one product from the body")
    @ResponseStatus(HttpStatus.CREATED) // response 201 for creation
    public ResponseEntity<ProductDTOOUT> addProduct(@RequestBody ProductDTOIN productDTOIN) throws IOException //We use @Request Body to map the json body into the object Product
    {
        // Convert the DTO to a Product entity using the mapper
        Product product_to_add = ProductMapper.to_Entity(productDTOIN);

        // Save the product using the service
        Product createdProduct = this.productservice.addProduct(product_to_add);

        // Convert the created product back to a DTO for the response
        ProductDTOOUT dtoOut = ProductMapper.to_DTO_OUT(createdProduct);

        // Return the created product with the status "201" (created)
        return new ResponseEntity<>(dtoOut, HttpStatus.CREATED);
    }


    @PatchMapping("/products/{id}")
    @Operation(summary = "Modify the product with the id provided")
    @ResponseStatus(HttpStatus.CREATED) // response 201 for creation
    public ResponseEntity<ProductDTOOUT> updateProduct(@PathVariable("id") UUID productId, @RequestBody Product product_newdatas) throws IOException
    {
        // Check the product we want
        Optional<Product> product = productservice.getProduct(productId);
        // Optional would not be necessary because I check already in the service: maybe I should make it more coherent but I checked it in the previous request

        // if the product is found, proceed to update it
        if (product.isPresent())
        {
            // Perform the patch update
            Product updatedProduct = productservice.updateProduct(productId, product_newdatas);

            // map the updated Product entity to ProductDTOOUT
            ProductDTOOUT dtoOut = ProductMapper.to_DTO_OUT(updatedProduct);

            // return the DTO with an OK
            return new ResponseEntity<>(dtoOut, HttpStatus.OK);
        }
        else
        {
            // if the product is not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/products/{id}")
    @Operation(summary = "Delete the product possesing this id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductDTOOUT> deleteProduct(@PathVariable("id") UUID productId) throws IOException
    {
        // Get the product we want
        Optional<Product> product = productservice.getProduct(productId);

        // If the product is found, we return it with a 200
        if (product.isPresent())
        {
            // Convert to DTO : I don't think it's necessary because we delete but I will stay coherent
            ProductDTOOUT DTO_OUT = ProductMapper.to_DTO_OUT(product.get()); // Convert to DTO

            productservice.deleteProduct(productId); // delete the product
            return new ResponseEntity<>(DTO_OUT, HttpStatus.OK);
        }
        // if the product is not found, we return a 404
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
