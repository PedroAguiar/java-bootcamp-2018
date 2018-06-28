package com.globant.model;

        import java.util.ArrayList;
        import java.util.List;

public class Order {private int id;
    private List<Item> ItemList = new ArrayList<Item> ();

    public Order() {
    }

    public Order( int id ) {
        this.id = id;
    }

    public Order( int id, List <Item> ItemList ) {
        this.id = id;
        ItemList = ItemList;
    }

    public Order( int id, Item item){
        this.id = id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                '}';
    }
}
