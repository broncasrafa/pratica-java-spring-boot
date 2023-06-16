package com.rsfrancisco.course.services;

import com.rsfrancisco.course.entities.Order;
import com.rsfrancisco.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository _orderRepository;

    public List<Order> findAll() {
        return _orderRepository.findAll();
    }

    public List<Order> findAllByUserId(Long clientId) {
        return _orderRepository.findAll()
                        .stream()
                        .filter(c -> c.getClient()
                        .getId() == clientId)
                        .toList();
    }

    public Order findById(Long orderId) {
        Optional<Order> obj = _orderRepository.findById(orderId);
        return obj.get();
    }
}
