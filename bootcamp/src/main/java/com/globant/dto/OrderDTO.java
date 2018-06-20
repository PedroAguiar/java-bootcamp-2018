package com.globant.dto;

import com.globant.model.Item;

import java.util.ArrayList;

public class OrderDTO {
    private int id;
    private ArrayList<Item> ItemList;

    public OrderDTO() {
    }

    public OrderDTO( int id ) {
        this.id = id;
    }

    public OrderDTO( int id, ArrayList <Item> itemList ) {
        this.id = id;
        ItemList = itemList;
    }

    public int getId() {
        return id;
    }

    public ArrayList <Item> getItemList() {
        return ItemList;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public void setItemList( ArrayList <Item> itemList ) {
        ItemList = itemList;
    }
}

