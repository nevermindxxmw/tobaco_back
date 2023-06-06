package com.sergio.jwt.backend.dtos.tobacoo;

import com.sergio.jwt.backend.entites.tobacoo.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    public String id;

    public String name;

    public String imageLink;

    public int price;

    public int count;

    public String categoryId;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.imageLink = product.getImageLink();
        this.price = product.getPrice();
        this.count = product.getCount();
        this.categoryId = product.getCategory().getId();
    }
}