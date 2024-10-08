package com.example.Alten_SQL.controller.dto;

//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Using lombok instead of writings the setters and getters
@Getter
@Setter
@NoArgsConstructor
public class ProductDTOOUT
{
    private UUID id;                         // Unique identifier for the product
    private String code;                     // Unique code for the product
    private String name;                     // Name of the product
    private String description;              // Description of the product
    private String image;                    // URL of the product image
    private String category;                 // Category of the product
    private BigDecimal price;                // Price of the product
    private Integer quantity;                // Quantity available
    private String internalReference;        // Internal reference ID
    private Integer shellId;                 // Shell ID for organization or categorization
    private String inventoryStatus;          // Inventory status (e.g., INSTOCK, LOWSTOCK, OUTOFSTOCK)
    private BigDecimal rating;               // Product rating
    private LocalDateTime createdAt;         // Timestamp when the product was created
    private LocalDateTime updatedAt;         // Timestamp when the product was last updated

    // Getters and Setters
//    public UUID getId()
//    {
//        return id;
//    }
//
//    public void setId(UUID id)
//    {
//        this.id = id;
//    }
//
//    public String getCode()
//    {
//        return code;
//    }
//
//    public void setCode(String code)
//    {
//        this.code = code;
//    }
//
//    public String getName()
//    {
//        return name;
//    }
//
//    public void setName(String name)
//    {
//        this.name = name;
//    }
//
//    public String getDescription()
//    {
//        return description;
//    }
//
//    public void setDescription(String description)
//    {
//        this.description = description;
//    }
//
//    public String getImage()
//    {
//        return image;
//    }
//
//    public void setImage(String image)
//    {
//        this.image = image;
//    }
//
//    public String getCategory()
//    {
//        return category;
//    }
//
//    public void setCategory(String category)
//    {
//        this.category = category;
//    }
//
//    public BigDecimal getPrice()
//    {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price)
//    {
//        this.price = price;
//    }
//
//    public Integer getQuantity()
//    {
//        return quantity;
//    }
//
//    public void setQuantity(Integer quantity)
//    {
//        this.quantity = quantity;
//    }
//
//    public String getInternalReference()
//    {
//        return internalReference;
//    }
//
//    public void setInternalReference(String internalReference)
//    {
//        this.internalReference = internalReference;
//    }
//
//    public Integer getShellId()
//    {
//        return shellId;
//    }
//
//    public void setShellId(Integer shellId)
//    {
//        this.shellId = shellId;
//    }
//
//    public String getInventoryStatus()
//    {
//        return inventoryStatus;
//    }
//
//    public void setInventoryStatus(String inventoryStatus)
//    {
//        this.inventoryStatus = inventoryStatus;
//    }
//
//    public BigDecimal getRating()
//    {
//        return rating;
//    }
//
//    public void setRating(BigDecimal rating)
//    {
//        this.rating = rating;
//    }
//
//    public LocalDateTime getCreatedAt()
//    {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt)
//    {
//        this.createdAt = createdAt;
//    }
//
//    public LocalDateTime getUpdatedAt()
//    {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(LocalDateTime updatedAt)
//    {
//        this.updatedAt = updatedAt;
//    }
}
