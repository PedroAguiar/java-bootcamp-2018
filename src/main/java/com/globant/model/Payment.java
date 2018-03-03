package com.globant.model;

public class Payment {
    private int id;
    private Float amount;
    private int idOrder;

    public Payment() {
    }

    public Payment(int id) {
        this.id = id;
    }

    public Payment(Float amount, int idOrder) {
        this.amount = amount;
        this.idOrder = idOrder;
    }

    public Payment(int id, Float amount, int idOrder) {
        this.id = id;
        this.amount = amount;
        this.idOrder = idOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }
}
