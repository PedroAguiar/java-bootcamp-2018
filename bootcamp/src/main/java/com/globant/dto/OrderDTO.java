package com.globant.dto;

import com.globant.model.Item;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO {
    private int id;
    private List<Item> ItemList = new ArrayList<Item> ();

    public OrderDTO() {
    }

    public OrderDTO( int id ) {
        this.id = id;
    }

    public OrderDTO( int id, List <Item> itemList ) {
        this.id = id;
        ItemList = itemList;
    }

    public int getId() {
        return id;
    }

    public List <Item> getItemList() {
        return ItemList;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public void setItemList( List <Item> itemList ) {
        ItemList = itemList;
    }
}

