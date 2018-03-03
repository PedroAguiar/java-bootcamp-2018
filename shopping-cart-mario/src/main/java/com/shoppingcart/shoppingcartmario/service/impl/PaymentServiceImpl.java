package com.shoppingcart.shoppingcartmario.service.impl;

import com.shoppingcart.shoppingcartmario.dto.PaymentDTO;
import com.shoppingcart.shoppingcartmario.model.Client;
import com.shoppingcart.shoppingcartmario.model.Order;
import com.shoppingcart.shoppingcartmario.model.Payment;
import com.shoppingcart.shoppingcartmario.repository.ClientRepository;
import com.shoppingcart.shoppingcartmario.repository.OrderRepository;
import com.shoppingcart.shoppingcartmario.repository.PaymentRepository;
import com.shoppingcart.shoppingcartmario.service.PaymentService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
//    private final ClientRepository clientRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }


    @Override
    public Payment createPayment(Payment payment) {
        Validate.isTrue(!paymentExists(payment.getAmount()));
        return paymentRepository.save(payment);
    }

    @Override
    public Payment createPayment(Payment payment, Integer clientId, Integer  orderId) {
        Validate.isTrue(!paymentExists(payment.getAmount()));
        return paymentRepository.save(payment);
    }

    @Override
    public Payment createPayment(PaymentDTO paymentDTO) {
        Validate.notNull(paymentDTO);
        final Order order = orderRepository.getOne((paymentDTO.getOrderId()));
        final Payment payment = Payment.builder()
                .pedido(order)
                .amount(paymentDTO.getAmount())
                .build();
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPayment(Integer paymentId) {
        Validate.isTrue(paymentExists(paymentId));
        return paymentRepository.getOne(paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    //We need this to be transactional because of the @Modifying query
    @Transactional
    public void updatePayment(Payment payment) {
        Validate.isTrue(paymentExists(payment.getId()));
        paymentRepository.update(payment.getAmount(), payment.getId());
    }

    @Override
    public void deletePayment(Integer idPayment) {
        paymentRepository.deleteById(idPayment);
    }

    private boolean paymentExists(String amount) {
        return paymentRepository.findByAmount(amount) != null;
    }

    private boolean paymentExists(Integer paymentId) {
        return paymentRepository.findById(paymentId).isPresent();
    }
}
