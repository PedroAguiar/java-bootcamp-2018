package com.globant.shoppingcartdemoapp.controller;


import com.globant.shoppingcartdemoapp.entities.Item;
import com.globant.shoppingcartdemoapp.entities.ShoppingOrder;
import com.globant.shoppingcartdemoapp.entities.Payment;
import com.globant.shoppingcartdemoapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private PaymentService paymentService;


    @RequestMapping(value="/client/{idClient}/payment/{idPayment}/orders", method = RequestMethod.POST)
    public void addOrder(@RequestBody ShoppingOrder shoppingOrder, @PathVariable int idPayment) {
        Payment p = paymentService.getPayment(idPayment);
        p.setShoppingOrder(shoppingOrder);
        orderService.addOrder(shoppingOrder);

    }

    @RequestMapping(value="/client/{idClient}/payment/{idPayment}/order/{idOrder}/item/{idItem}",method = RequestMethod.POST)

    public void addItemToOrder(@PathVariable int idOrder, @PathVariable int idItem) {

       Item i = itemService.getItem(idItem);
       ShoppingOrder o = orderService.getOrder(idOrder);

       o.getItem().add(i);

    }

    @RequestMapping(value="client/{idClient}/payment/{idPayment}/order/{orderId}",method = RequestMethod.GET)
    public ShoppingOrder getOrder(@PathVariable int orderId) {
        return orderService.getOrder(orderId);
    }

    @RequestMapping(value="client/{idClient}/payment/{idPayment}/order",method = RequestMethod.PUT)
    public void updateOrder(@PathVariable ShoppingOrder shoppingOrder) {
        orderService.updateOrder(shoppingOrder);
    }

    @RequestMapping(value="client/{idClient}/payment/{idPayment}/order/{orderId}",method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable int orderId) {
        orderService.deleteOrder(orderId);
    }




}
