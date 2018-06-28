package com.globant.dto;


import com.globant.model.Order;

public class PaymentDTO {
  private int id;
  private Order order;
  private float amount;

    public PaymentDTO() {
    }

    public PaymentDTO( int id ) {
        this.id = id;
    }

    public PaymentDTO( int id, Order order, float amount ) {
        this.id = id;
        this.order = order;
        this.amount = amount;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public void setOrder( Order order ) {
        this.order = order;
    }

    public void setAmount( float amount ) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public float getAmount() {
        return amount;
    }
}
