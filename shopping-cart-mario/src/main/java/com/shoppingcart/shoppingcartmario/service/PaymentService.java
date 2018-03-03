package com.shoppingcart.shoppingcartmario.service;

import com.shoppingcart.shoppingcartmario.dto.PaymentDTO;
import com.shoppingcart.shoppingcartmario.model.Payment;

import java.util.List;

public interface PaymentService  {
    List<Payment> getAllPayments();
    Payment getPayment(Integer idPayment);
    Payment createPayment(Payment payment);
    Payment createPayment(Payment payment, Integer idOrder, Integer idClient);
    Payment createPayment(PaymentDTO payment);
    void updatePayment(Payment payment);
    void deletePayment(Integer idPayment);
}
