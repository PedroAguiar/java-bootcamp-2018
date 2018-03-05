package com.shoppingcart.shoppingcartmario.service.impl;

import com.shoppingcart.shoppingcartmario.model.Order;
import com.shoppingcart.shoppingcartmario.repository.OrderRepository;
import com.shoppingcart.shoppingcartmario.service.OrderService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        Validate.isTrue(!orderExists(order.getName()));
        return orderRepository.save(order);
    }

    @Override
    public Order getOrder(Integer orderId) {
        Validate.isTrue(orderExists(orderId));
        return orderRepository.getOne(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    //We need this to be transactional because of the @Modifying query
    @Transactional
    public void updateOrder(Order order) {
        Validate.isTrue(orderExists(order.getId()));
        orderRepository.update(order.getName(), order.getId());
    }

    @Override
    public void deleteOrder(Integer idOrder) {
        orderRepository.deleteById(idOrder);
    }


    private boolean orderExists(String name) {
        return orderRepository.findByName(name) != null;
    }

    private boolean orderExists(Integer orderId) {
        return orderRepository.findById(orderId).isPresent();
    }
}
