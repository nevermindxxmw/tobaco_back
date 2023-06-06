package com.sergio.jwt.backend.services.impl;

import com.sergio.jwt.backend.dtos.tobacoo.PurchaseDto;
import com.sergio.jwt.backend.entites.Order;
import com.sergio.jwt.backend.entites.User;
import com.sergio.jwt.backend.entites.tobacoo.Product;
import com.sergio.jwt.backend.repositories.OrderRepository;
import com.sergio.jwt.backend.repositories.ProductRepository;
import com.sergio.jwt.backend.repositories.UserRepository;
import com.sergio.jwt.backend.services.PurchaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public PurchaseServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void purchaseProducts(PurchaseDto purchaseDto, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user does no exist"));
        List<Order.OrderItem> items = purchaseDto.getProducts().stream()
                .map(p -> {
                    Product product = productRepository.findById(p.getId())
                            .orElseThrow(() -> new RuntimeException("Product id "+  p.getId()));

                    if (product.getCount() < p.getCount()) {
                        throw new RuntimeException("Not enough products for purchase: " + product.getName());
                    }

                    product.setCount(product.getCount() - p.getCount());
                    productRepository.save(product);

                    Order.OrderItem orderItem = new Order.OrderItem();
                    orderItem.setProduct(product);
                    orderItem.setPrice(product.getPrice());
                    orderItem.setCount(p.getCount());

                    return orderItem;
                })
                .collect(Collectors.toList());

        int totalPrice = items.stream()
                .mapToInt(i -> i.getPrice() * i.getCount())
                .sum();

        user.setBonus(user.getBonus() + totalPrice / 10);
///скидки 10 проц 59 строка
        Order order = Order.builder()
                .userId(userId)
                .items(items)
                .totalPrice(totalPrice)
                .build();

        userRepository.save(user);
        orderRepository.save(order);
    }
}