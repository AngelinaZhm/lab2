package com.example.lab2.service;

import com.example.lab2.model.Order;
import com.example.lab2.model.User;
import com.example.lab2.repository.OrderRepository;
import com.example.lab2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public Order createOrder(Long userId, Order order) {
        User user = userRepository.findById(userId).orElseThrow();
        order.setUser(user);
        return orderRepository.save(order);
    }

    public List<Order> getOrderByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
