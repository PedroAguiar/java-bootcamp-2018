package com.bootcamp2018.dto;


import com.bootcamp2018.model.Order;

public class OrderDTO {
    private int idPayment;
    private Order order;

    public OrderDTO(int idPayment, Order order) {
        this.idPayment = idPayment;
        this.order = order;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
