package com.sergio.jwt.backend.entites.tobacoo;

import com.sergio.jwt.backend.dtos.tobacoo.CategoryDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 64, updatable = false, nullable = false)
    private String id;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String title;

    public Category(CategoryDto categoryDto) {
        this.name = categoryDto.getName();
        this.title = categoryDto.getTitle();
    }
    public Category(String name, String title){
        this.name = name;
        this.title = title;
    }

}