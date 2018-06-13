package com.bootcamp2018.model;

public class Discount {
    private Item item;
    private int quantity;
    private double price;

    public Discount() {
        this.item = new Item();
        this.quantity = 0;
        this.price = 0;
    }

    public Discount(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.price = 0;
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
            if (Discount.class.isAssignableFrom(obj.getClass())) {
                final Discount other = (Discount) obj;
                ban = this.item.equals(other) && this.quantity == other.quantity;
            }
        }
        return ban;
    }
}
