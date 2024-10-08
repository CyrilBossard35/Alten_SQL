package com.example.Alten_SQL.controller.dto;

//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

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
public class ProductDTOIN
{

    @NotBlank(message = "Code cannot be blank")
    private String code;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    private String description;
    private String image;
    private String category;

    @NotNull(message = "Price cannot be null")
    private BigDecimal price;

    @NotNull(message = "Quantity cannot be null")
    private Integer quantity;

    private String internalReference;
    private Integer shellId;

    @NotBlank(message = "Inventory status cannot be blank")
    private String inventoryStatus;

    private BigDecimal rating;

//    // Getters and Setters
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
}