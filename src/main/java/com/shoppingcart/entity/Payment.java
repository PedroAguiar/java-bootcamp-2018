package com.shoppingcart.entity;

public class Payment {
    private Integer id;
    private Float amount;
    private Integer idOrder;

    public Payment(Integer id) {
        this.id = id;
    }

    public Payment(Integer id, Float amount) {
        this.id = id;
        this.amount = amount;
    }

    public Payment(Integer id, Float amount, Integer idOrder) {
        this.amount = amount;
        this.idOrder = idOrder;
    }

    public Payment(Float amount, Integer idOrder) {
        this.id = id;
        this.amount = amount;
        this.idOrder = idOrder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }
}
