package com.bootcamp2018.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetail {
    @Autowired
    private Item item;
    private int quantity;
    private double price;

    public OrderDetail() {
        this.item = new Item();
        this.quantity = 0;
        this.price = 0;
    }

    public OrderDetail(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.price = item.getPrice();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        boolean ban = false;
        if (obj != null) {
            if (OrderDetail.class.isAssignableFrom(obj.getClass())) {
                final OrderDetail other = (OrderDetail) obj;
                if (this.getItem().equals(other.getItem())) {
                    ban = true;
                }
            }
        }
        return ban;
    }

    @Override
    public String toString() {
        return "Item: " + this.item.getName() + ", quantity: " + this.quantity + ", unit price: $" + this.price;
    }

    public double getSubTotal() {
        return this.price * this.quantity;
    }
}
