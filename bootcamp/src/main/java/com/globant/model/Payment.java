package com.globant.model;

public class Payment { private int id;
    private Order order;
    private float amount;

    public Payment(int id, Order order, float amount){
        this.id = id;
        this.order = order;
        this.amount = amount;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setOrder( Order order ) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setAmount( float amount ) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }
}
