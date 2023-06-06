package com.sergio.jwt.backend.dtos.tobacoo;

import com.sergio.jwt.backend.entites.tobacoo.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    public String id;

    public String name;

    public String title;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.title = category.getTitle();
    }
}
