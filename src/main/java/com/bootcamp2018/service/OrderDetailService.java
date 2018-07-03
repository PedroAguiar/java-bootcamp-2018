package com.bootcamp2018.service;

import com.bootcamp2018.dto.OrderDetailDTO;

import java.util.ArrayList;

public class OrderDetailService implements Service<OrderDetailDTO> {
    @Override
    public OrderDetailDTO create(OrderDetailDTO Object) {

        return Object;
    }

    @Override
    public OrderDetailDTO get(OrderDetailDTO Object) {
        return null;
    }

    @Override
    public ArrayList<OrderDetailDTO> getList(OrderDetailDTO Object) {
        return null;
    }

    @Override
    public OrderDetailDTO update(OrderDetailDTO Object) {
        return null;
    }

    @Override
    public void delete(OrderDetailDTO Object) {
    }
}
