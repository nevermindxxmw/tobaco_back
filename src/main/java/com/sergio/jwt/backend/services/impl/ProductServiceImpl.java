package com.sergio.jwt.backend.services.impl;

import com.sergio.jwt.backend.dtos.tobacoo.CategoryDto;
import com.sergio.jwt.backend.dtos.tobacoo.ProductDto;
import com.sergio.jwt.backend.entites.tobacoo.Category;
import com.sergio.jwt.backend.entites.tobacoo.Product;
import com.sergio.jwt.backend.repositories.CategoryRepository;
import com.sergio.jwt.backend.repositories.ProductRepository;
import com.sergio.jwt.backend.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public ProductServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public String saveCategory(CategoryDto categoryDto) {
        if (categoryRepository.existsByName(categoryDto.getName())) {
            throw new RuntimeException("category already exist");
        }
        Category category = new Category(categoryDto);
        categoryRepository.save(category);
        return category.getId();
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream().map(CategoryDto::new).toList();
    }

    @Override
    public String saveProduct(ProductDto productDto) {
        if (productRepository.existsByName(productDto.getName())) {
            throw new RuntimeException("Product already exist");
        }
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category does not exist"));
        Product product = new Product(productDto, category);
        productRepository.save(product);

        return product.getId();
    }

    @Override
    public List<ProductDto> getAllProducts(String categoryName){
        Category category = categoryRepository.findByName(categoryName);
        if(category == null){
            throw new RuntimeException("category does not exist");
        }
        return productRepository.findAllByCategory(category).stream().map(ProductDto::new).toList();
    }
}
