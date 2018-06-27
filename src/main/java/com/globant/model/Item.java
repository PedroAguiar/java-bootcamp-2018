package com.globant.model;

public class Item {private int id;
    private String name;
    private float price;

    public Item() {
    }

    public Item( int id ) {
        this.id = id;
    }

    public Item( int id, String name, float price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice( float price ) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "price=" + price +
                '}';
    }
}
