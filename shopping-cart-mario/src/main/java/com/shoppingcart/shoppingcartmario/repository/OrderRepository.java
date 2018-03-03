package com.shoppingcart.shoppingcartmario.repository;

import com.shoppingcart.shoppingcartmario.model.Order;
import com.shoppingcart.shoppingcartmario.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findByName(String name);

    @Modifying
    @Query("UPDATE Order SET name = :name WHERE id = :orderId")
    void update(@Param("name") String name, @Param("orderId") Integer orderId);
}