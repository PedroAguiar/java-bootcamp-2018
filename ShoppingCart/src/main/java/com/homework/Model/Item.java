package com.homework.Model;

public class Item {
    private int id;
    private String name;
    private int idOrder;

    public Item() {
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(String name, int idOrder) {
        this.name = name;
        this.idOrder = idOrder;
    }

    public Item(int id, String name, int idOrder) {
        this.id = id;
        this.name = name;
        this.idOrder = idOrder;
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

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }
}
