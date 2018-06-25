package com.bootcamp2018.control;

import com.bootcamp2018.dto.PaymentDTO;
import org.graalvm.compiler.serviceprovider.ServiceProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
@Controller
@RequestMapping("/")
public class PaymentControl implements Control<PaymentDTO> {

    @RequestMapping(value = "/", method = RequestMethod.GET)
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
