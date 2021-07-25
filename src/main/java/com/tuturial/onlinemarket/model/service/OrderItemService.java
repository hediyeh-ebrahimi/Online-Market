package com.tuturial.onlinemarket.model.service;

import com.tuturial.onlinemarket.model.entity.OrderItem;
import com.tuturial.onlinemarket.model.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderItemService {

    private OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Transactional
    public void add(OrderItem orderItem) {
        this.orderItemRepository.save(orderItem);
    }

    public List<OrderItem> findAll() {
        return this.orderItemRepository.findAll();
    }
}
