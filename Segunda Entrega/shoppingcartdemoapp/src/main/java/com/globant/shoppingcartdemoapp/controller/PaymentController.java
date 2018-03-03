package com.globant.shoppingcartdemoapp.controller;
import com.globant.shoppingcartdemoapp.service.*;
import com.globant.shoppingcartdemoapp.entities.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ClientService clientService;

    @RequestMapping(value="/client/{clientId}/payment",method = RequestMethod.POST)
    public void addPayment(@RequestBody Payment payment, @PathVariable int clientId) {
        Client c = clientService.getClient(clientId);
        c.getPayment().add(payment);
        payment.setClient(c);

        paymentService.add(payment);
    }

    @RequestMapping(value="/client/{clientId}/payments", method = RequestMethod.GET)
    public List<Payment> getAllPayments(@PathVariable int clientId) {
        return paymentService.getAllPayments(clientId);
    }

    @RequestMapping(value="/client/{clientId}/payment/{paymentId}",method = RequestMethod.GET)
    public Payment getPayment(@PathVariable int paymentId) {
        return paymentService.getPayment(paymentId);
    }

    @RequestMapping(value="/client/{clientId}/payment",method = RequestMethod.PUT)
    public void updatePayment(@RequestBody Payment payment, @PathVariable int clientId) {

        Client c = clientService.getClient(clientId);
        for(int i = 0 ; i < c.getPayment().size() ; i++) {
            if(c.getPayment().get(i).getId() == clientId) {
                c.getPayment().add(i,payment);
            }
        }
        paymentService.updatePayment(payment);
    }

    @RequestMapping(value="/client/{clientId}/payment/{paymentId}",method = RequestMethod.DELETE)
    public void deletePayment(@PathVariable int paymentId, @PathVariable int clientId) {

        Client c = clientService.getClient(clientId);
        for(int i = 0 ; i < c.getPayment().size() ; i++) {
            if(c.getPayment().get(i).getId() == clientId) {
                c.getPayment().remove(i);
            }
        }
        paymentService.deletePayment(paymentId);
    }

}
