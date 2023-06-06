package com.sergio.jwt.backend.controllers.tobacoo;

import com.sergio.jwt.backend.dtos.tobacoo.CategoryDto;
import com.sergio.jwt.backend.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final ProductService productService;

    public CategoryController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<CategoryDto> getAllCategories() {
        return productService.getAllCategories();
    }

    @PostMapping()
    public String addCategory(@RequestBody() CategoryDto categoryDto) {
        return productService.saveCategory(categoryDto);
    }
}
