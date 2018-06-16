package com.bootcamp2018.dto;

import com.bootcamp2018.model.Payment;

public class PaymentDTO {
    private Payment payment;
    private int idClient;

    public PaymentDTO() {
        payment =new Payment();

    }

    public PaymentDTO(Payment payment, int idClient) {
        this.payment = payment;
        this.idClient = idClient;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}
