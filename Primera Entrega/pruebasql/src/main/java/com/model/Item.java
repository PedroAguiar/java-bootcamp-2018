package com.model;

public class Item {

    private int id;
    private String name;
    private float price;


    public Item(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
