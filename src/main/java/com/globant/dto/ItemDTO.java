package com.globant.dto;

public class ItemDTO {
    private int id;
    private String name;
    private float price;

    public ItemDTO() {
    }

    public ItemDTO( int id ) {
        this.id = id;
    }

    public ItemDTO( int id, String name, float price ) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public void setPrice( float price ) {
        this.price = price;
    }
}
