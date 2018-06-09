package com.globant.model;

public class Order {private int id;
    private Item item;

    public Order(int id, Item item){
        this.id = id;
        this.item = item;

    }

    public void setId( int id ) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setItem( Item item ) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
