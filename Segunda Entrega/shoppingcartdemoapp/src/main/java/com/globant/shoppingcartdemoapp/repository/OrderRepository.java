package com.globant.shoppingcartdemoapp.repository;

import com.globant.shoppingcartdemoapp.entities.Client;
import com.globant.shoppingcartdemoapp.entities.ShoppingOrder;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.Order;

public interface OrderRepository extends CrudRepository<ShoppingOrder,Integer> {

    ShoppingOrder getById(int orderId);

}


