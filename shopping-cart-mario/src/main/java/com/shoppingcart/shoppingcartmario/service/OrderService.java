package com.shoppingcart.shoppingcartmario.service;

import com.shoppingcart.shoppingcartmario.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrder(Integer idOrder);
    Order createOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(Integer idOrder);
}
