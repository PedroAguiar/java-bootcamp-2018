package com.bootcamp2018.dto;

import com.bootcamp2018.model.OrderDetail;

public class OrderDetailDTO {
    private int idOrder;
    private OrderDetail orderDetail;

    public OrderDetailDTO(int idOrder, OrderDetail orderDetail) {
        this.idOrder = idOrder;
        this.orderDetail = orderDetail;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }
}
