package com.globant.shoppingcartdemoapp.service;


import com.globant.shoppingcartdemoapp.entities.Order;
import com.globant.shoppingcartdemoapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public Order getOrder(int orderId) {
        return orderRepository.getById(orderId);
    }

    public void updateOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }
}
