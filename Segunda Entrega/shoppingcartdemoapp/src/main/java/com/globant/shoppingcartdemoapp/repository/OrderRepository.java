package com.globant.shoppingcartdemoapp.repository;

import com.globant.shoppingcartdemoapp.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Integer> {

    Order getById(int orderId);
}
