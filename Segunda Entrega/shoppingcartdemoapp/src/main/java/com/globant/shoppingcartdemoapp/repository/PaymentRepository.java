package com.globant.shoppingcartdemoapp.repository;

import com.globant.shoppingcartdemoapp.entities.Payment;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.Order;
import java.util.List;

public interface PaymentRepository extends CrudRepository<Payment,Integer> {

    List<Payment> findAllByClientId(int clientId);
    Payment findById(int paymentId);

}
