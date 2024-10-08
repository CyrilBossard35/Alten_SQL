package com.example.Alten_SQL.controller.dto;
import com.example.Alten_SQL.model.Product;
import com.example.Alten_SQL.controller.dto.ProductDTOOUT;
import com.example.Alten_SQL.controller.dto.ProductDTOIN;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

// Mapper handles the conversion between  the object types
@Component
public class ProductMapper
{

    // Convert Product entity to ProductDTOOut
    public static ProductDTOOUT to_DTO_OUT(Product product)
    {
        ProductDTOOUT dtoOut = new ProductDTOOUT();

        dtoOut.setId(product.getId());
        dtoOut.setCode(product.getCode());
        dtoOut.setName(product.getName());
        dtoOut.setDescription(product.getDescription());
        dtoOut.setImage(product.getImage());
        dtoOut.setCategory(product.getCategory());

        dtoOut.setPrice(product.getPrice());
        dtoOut.setQuantity(product.getQuantity());
        dtoOut.setInternalReference(product.getInternalReference());
        dtoOut.setShellId(product.getShellId());
        dtoOut.setInventoryStatus(product.getInventoryStatus());

        dtoOut.setRating(product.getRating());


        // check if null before parsing llocaldatetime
        if (product.getCreatedAt() != null)
        {
            dtoOut.setCreatedAt(product.getCreatedAt()); // Assuming createdAt is already LocalDateTime
        }
        else
        {
            // Handle the null case as needed, e.g., set to a default value or log a warning
            dtoOut.setCreatedAt(LocalDateTime.now()); // Or however you want to handle it
        }

        if (product.getUpdatedAt() != null)
        {
            dtoOut.setUpdatedAt(product.getUpdatedAt()); // Assuming updatedAt is already LocalDateTime
        }
        else
        {
            // Handle the null case as needed
            dtoOut.setUpdatedAt(LocalDateTime.now()); // Or however you want to handle it
        }

        return dtoOut;
    }

    // Convert ProductDTOIn to Product entity
    public static Product to_Entity(ProductDTOIN dtoIn)
    {
        Product product = new Product();
        product.setCode(dtoIn.getCode());
        product.setName(dtoIn.getName());
        product.setDescription(dtoIn.getDescription());
        product.setImage(dtoIn.getImage());
        product.setCategory(dtoIn.getCategory());

        if (dtoIn.getPrice() != null)
        {
            product.setPrice(dtoIn.getPrice()); // it's a big decimal here
        }

        if (dtoIn.getQuantity() != null)
        {
            product.setQuantity(dtoIn.getQuantity());
        }

        product.setInternalReference(dtoIn.getInternalReference());
        product.setShellId(dtoIn.getShellId());
        product.setInventoryStatus(dtoIn.getInventoryStatus());

        if (dtoIn.getRating() != null)
        {
            product.setPrice(dtoIn.getRating()); // same it's a big decimal here
        }
        return product;
    }
}
