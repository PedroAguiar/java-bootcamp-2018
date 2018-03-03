package com.globant.shoppingcartdemoapp.service;


import com.globant.shoppingcartdemoapp.entities.ShoppingOrder;
import com.globant.shoppingcartdemoapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public void addOrder(ShoppingOrder shoppingOrder) {
        orderRepository.save(shoppingOrder);
    }

    public ShoppingOrder getOrder(int orderId) {
        return orderRepository.getById(orderId);
    }

    public void updateOrder(ShoppingOrder shoppingOrder) {
        orderRepository.save(shoppingOrder);
    }

    public void deleteOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }
}
