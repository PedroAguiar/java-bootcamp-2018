package com.globant.model;



public class Payment { private int id_payment;
    private Order order;
    private float amount;

    public Payment() {
    }

    public Payment( int id_payment ) {
        this.id_payment = id_payment;
    }

    public Payment( int id_payment, Order order, float amount){
        this. id_payment= id_payment;
        this.order = order;
        this.amount = amount;
    }

    public void setId( int id_payment ) {
        this.id_payment =id_payment ;
    }

    public int getid_payment() {
        return id_payment;
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

    @Override
    public String toString() {
        return "Payment{" +
                "id_payment=" + id_payment +
                ", order=" + order +
                ", amount=" + amount +
                '}';
    }
}
