package com.bootcamp2018.service;

import com.bootcamp2018.dto.PaymentDTO;

import java.util.ArrayList;

public class PaymentService implements Service<PaymentDTO> {
    @Override
    public PaymentDTO create(PaymentDTO Object) {

        return Object;
    }

    @Override
    public PaymentDTO get(PaymentDTO Object) {
        return null;
    }

    @Override
    public ArrayList<PaymentDTO> getList(PaymentDTO Object) {
        return null;
    }

    @Override
    public PaymentDTO update(PaymentDTO Object) {
        return null;
    }

    @Override
    public void delete(PaymentDTO Object) {

    }
}
