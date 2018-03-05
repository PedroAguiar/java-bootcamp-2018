package com.shoppingcart.shoppingcartmario.controller;

import com.shoppingcart.shoppingcartmario.dto.PaymentDTO;
import com.shoppingcart.shoppingcartmario.model.Payment;
import com.shoppingcart.shoppingcartmario.service.PaymentService;
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
public class PaymentController {

    //This creates a Logger Object
    // that will be taking care of doing what you did with 'System.out.prinln statements' a.k.a 'logging'
    private Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    //@RequestMapping(value = "/payment")
    @GetMapping(value = "/payment/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") Integer id) {
        Payment payment = paymentService.getPayment(id);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @GetMapping(value = "/payments", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> list = paymentService.getAllPayments();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "{clientId}/order/{orderId}/payment", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Payment> addPayment(@PathVariable("clientId") Integer clientId,
                                              @PathVariable("orderId") Integer orderId,
                                              @RequestBody Payment payment) {

        //Logging example, the value of '{}' gets filled with the output of payment.toString()
        LOGGER.info("Adding payment {} ", payment.toString());
        PaymentDTO paymentDTO = new PaymentDTO(1, clientId, payment.getAmount());
        LOGGER.info("Adding paymentDTO {} ", paymentDTO.toString());
        final Payment persistedPayment = paymentService.createPayment(paymentDTO);
        Validate.notNull(persistedPayment);

        return new ResponseEntity<>(persistedPayment, HttpStatus.CREATED);
    }

    @PutMapping(value = "/payment", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment) {
        paymentService.updatePayment(payment);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/payment/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deletePayment(@PathVariable("id") Integer id) {
        paymentService.deletePayment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "payment", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {

        //Logging example, the value of '{}' gets filled with the output of payment.toString()
        LOGGER.info("Adding payment {} ", payment.toString());

        final Payment persistedPayment = paymentService.createPayment(payment);
        Validate.notNull(persistedPayment);

        return new ResponseEntity<>(persistedPayment, HttpStatus.CREATED);
    }

}
