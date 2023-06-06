package com.sergio.jwt.backend.repositories;

import com.sergio.jwt.backend.entites.tobacoo.Category;
import com.sergio.jwt.backend.entites.tobacoo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    boolean existsByName(String name);

    List<Product> findAllByCategory(Category category);
}
