package com.globant.shoppingcartdemoapp.controller;


import com.globant.shoppingcartdemoapp.entities.Item;
import com.globant.shoppingcartdemoapp.entities.Order;
import com.globant.shoppingcartdemoapp.entities.Payment;
import com.globant.shoppingcartdemoapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.globant.shoppingcartdemoapp.repository.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private PaymentService paymentService;


    @RequestMapping(value="/client/{idClient}/payment/{idPayment}/order", method = RequestMethod.POST)
    public void addOrder(@RequestBody Order order, @PathVariable int idPayment) {
        Payment p = paymentService.getPayment(idPayment);
        p.setOrder(order);
        orderService.addOrder(order);
    }

    @RequestMapping(value="/client/{idClient}/payment/{idPayment}/order/{idOrder}/item/{idItem}",method = RequestMethod.POST)

    public void addItemToOrder(@PathVariable int idOrder, @PathVariable int idItem) {

       Item i = itemService.getItem(idItem);
       Order o = orderService.getOrder(idOrder);

       o.getItems().add(i);

    }

    @RequestMapping(value="client/{idClient}/payment/{idPayment}/order/{orderId}",method = RequestMethod.GET)
    public Order getOrder(@PathVariable int orderId) {
        return orderService.getOrder(orderId);
    }

    @RequestMapping(value="client/{idClient}/payment/{idPayment}/order",method = RequestMethod.PUT)
    public void updateOrder(@PathVariable Order order) {
        orderService.updateOrder(order);
    }

    @RequestMapping(value="client/{idClient}/payment/{idPayment}/order/{orderId}",method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable int orderId) {
        orderService.deleteOrder(orderId);
    }




}
