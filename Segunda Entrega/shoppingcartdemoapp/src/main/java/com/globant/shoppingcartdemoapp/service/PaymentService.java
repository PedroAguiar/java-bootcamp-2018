package com.globant.shoppingcartdemoapp.service;

import com.globant.shoppingcartdemoapp.entities.*;
import com.globant.shoppingcartdemoapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {


    @Autowired
    private PaymentRepository paymentRepository;



    public void add(Payment payment) {
        paymentRepository.save(payment);
    }

    public Payment getPayment(int id) {
        return paymentRepository.findById(id);
    }

    public List<Payment> getAllPayments(int clientId) {
        return paymentRepository.findAllByClientId(clientId);
    }

    public void updatePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public void deletePayment(int id) {
        paymentRepository.deleteById(id);
    }
}
