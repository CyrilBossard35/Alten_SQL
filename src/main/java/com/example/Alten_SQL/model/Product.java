package com.example.Alten_SQL.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

// MODEL FOR THE BDD
@Entity  // Mapping to a database table
@Getter // Setting the getter for Product thanks to Lombok
@Setter // Setting the setter for Product thanks to Lombok
@AllArgsConstructor // Generate a constructor automaticallyy
@NoArgsConstructor // Generate a constructor without any arguments

@Table(name = "product")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, length = 100)
    private String code;

    @Column(unique = true, length = 100)
    private String name;

    @Column(unique = true, length = 500)
    private String description;

    @Column(unique = true, length = 100)
    private String image;

    @Column(unique = true, length = 100)
    private String category;

    @Column(unique = true, length = 100)
    private BigDecimal price;

    @Column(unique = true, length = 100)
    private Integer quantity;

    @Column(unique = true, length = 100)
    private String internalReference;

    @Column(unique = true, length = 100)
    private Integer shellId;

    @Column(unique = true, length = 100)
    private String inventoryStatus = "IN STOCK";

    @Column(unique = true, length = 100)
    private BigDecimal rating;

    @Column(unique = true, length = 100)
    private LocalDateTime createdAt;

    @Column(unique = true, length = 100)
    private LocalDateTime updatedAt;


}
