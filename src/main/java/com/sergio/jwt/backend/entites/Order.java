package com.sergio.jwt.backend.entites;

import com.sergio.jwt.backend.entites.tobacoo.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @ElementCollection
    private List<com.sergio.jwt.backend.entites.Order.OrderItem> items;

    @Column(nullable = false)
    private int totalPrice;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Embeddable
    @Data
    public static class OrderItem {
        @ManyToOne
        @JoinColumn(name = "product_id")
        private Product product;
        private int price;
        private int count;
    }
}
