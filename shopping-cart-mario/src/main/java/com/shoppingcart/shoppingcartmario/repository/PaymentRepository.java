package com.shoppingcart.shoppingcartmario.repository;

import com.shoppingcart.shoppingcartmario.model.Payment;
import com.shoppingcart.shoppingcartmario.model.Payment;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    Payment findByAmount(String amount);

    @Modifying
    @Query("UPDATE Payment SET amount = :amount WHERE id = :paymentId")
    void update(@Param("amount") String amount, @Param("paymentId") Integer paymentId);

//    @Modifying
//    @Query("UPDATE Payment P (P.amount, P.client_id, P.pedido_id) VALUES(:amount, :clientId, :pedidoId)")
//    public void insert(@Param("amount") String amount, @Param("clientId") Integer clientId, @Param("pedidoId") Integer pedidoId);
}