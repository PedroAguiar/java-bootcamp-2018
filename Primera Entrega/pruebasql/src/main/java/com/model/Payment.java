package com.model;

public class Payment {

    private int ID;
    private ShoppingCartOrder order;
    private float amount;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ShoppingCartOrder getOrder() {
        return order;
    }

    public void setOrder(ShoppingCartOrder order) {
        this.order = order;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
