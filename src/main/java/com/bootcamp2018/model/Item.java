package com.bootcamp2018.model;

public class Item {
    private int Id;
    private String name;
    private double price;

    public Item() {
        Id = 0;
        this.name = "";
        this.price = 0;
    }

    public Item(String name, double price) {
        Id = 0;
        this.name = name;
        this.price = price;
    }

    public Item(int id, String name, double price) {
        Id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
            if (Item.class.isAssignableFrom(obj.getClass())) {
                final Item other = (Item) obj;
                ban = this.getId() == other.getId();
            }
        }
        return ban;
    }

    @Override
    public String toString() {
        return  "Code: "+getId()+ ", Name: "+getName() +", Price: $"+ getPrice();
    }
}
