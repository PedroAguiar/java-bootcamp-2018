package com.shoppingcart.shoppingcartmario.controller;

import com.shoppingcart.shoppingcartmario.model.Item;
import com.shoppingcart.shoppingcartmario.model.Order;
import com.shoppingcart.shoppingcartmario.service.OrderService;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This is a convenience annotation that provides the @Controller & @ResponseBody functionalities
@RestController
public class OrderController {

    //This creates a Logger Object
    // that will be taking care of doing what you did with 'System.out.prinln statements' a.k.a 'logging'
    private Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //@RequestMapping(value = "/order")
    @GetMapping(value = "/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Integer id) {
        Order order = orderService.getOrder(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> list = orderService.getAllOrders();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {

        //Logging example, the value of '{}' gets filled with the output of order.toString()
        LOGGER.info("Adding order {} ", order.toString());

        final Order persistedOrder = orderService.createOrder(order);
        Validate.notNull(persistedOrder);

        return new ResponseEntity<>(persistedOrder, HttpStatus.CREATED);
    }

    @PutMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Integer id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/order/{id}/items", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Item>> getAllItems(@PathVariable("id") Integer id) {
        Order order = orderService.getOrder(id);
        return new ResponseEntity<>(order.getItems(), HttpStatus.OK);
    }

}
