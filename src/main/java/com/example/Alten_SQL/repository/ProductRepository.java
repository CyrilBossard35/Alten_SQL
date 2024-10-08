package com.example.Alten_SQL.repository;

import com.example.Alten_SQL.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>
{
    // JpaRepository provides basic CRUD operations out of the box
}