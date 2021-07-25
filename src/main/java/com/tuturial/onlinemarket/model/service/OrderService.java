package com.tuturial.onlinemarket.model.service;

import com.tuturial.onlinemarket.model.entity.Order;
import com.tuturial.onlinemarket.model.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order add(Order order) {
        return this.orderRepository.save(order);
    }

    @Transactional
    public void update(Order order) {
         this.orderRepository.save(order);
    }
}
