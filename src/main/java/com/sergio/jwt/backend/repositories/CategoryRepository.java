package com.sergio.jwt.backend.repositories;

import com.sergio.jwt.backend.entites.tobacoo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {

    Boolean existsByName(String name);

    Category findByName(String name);

}
