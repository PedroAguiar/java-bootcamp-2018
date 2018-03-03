package com.model;

import java.util.ArrayList;

public class ShoppingCartOrder {

    private int id;
    private float amount;
    private ArrayList<Item> itemList;

    public ShoppingCartOrder() {
        this.amount = 0;
        this.itemList = new ArrayList<Item>();
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }
}
