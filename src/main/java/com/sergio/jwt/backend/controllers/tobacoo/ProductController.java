package com.sergio.jwt.backend.controllers.tobacoo;

import com.sergio.jwt.backend.dtos.tobacoo.ProductDto;
import com.sergio.jwt.backend.services.ProductService;
import com.sergio.jwt.backend.services.PullUpService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;
    private final PullUpService pullUpService;

    public ProductController(ProductService productService, PullUpService pullUpService) {
        this.productService = productService;
        this.pullUpService = pullUpService;
    }

    @PostMapping()
    public String saveProduct(@RequestBody() ProductDto productDto) {
        return productService.saveProduct(productDto);
    }

    @GetMapping("/category/{categoryName}")
    public List<ProductDto> findAllProducts(@PathVariable String categoryName) {
        return productService.getAllProducts(categoryName);
    }
    @GetMapping("/fill")
    public void fillProducts(){
        pullUpService.fillUpDataBase();
    }
}
