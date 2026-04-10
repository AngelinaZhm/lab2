package com.example.lab2.controller;

import com.example.lab2.model.Order;
import com.example.lab2.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/users/{userId}/orders")
    public Order createOrder(@PathVariable Long userId, @RequestBody Order order) {
        return orderService.createOrder(userId, order);
    }

    @GetMapping("/users/{userId}/orders")
    public List<Order> getOrders(@PathVariable Long userId) {
        return orderService.getOrderByUser(userId);
    }
}
