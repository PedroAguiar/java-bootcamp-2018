package com.globant.model;

        import java.util.ArrayList;

public class Order {private int id;
    private ArrayList<Item> PaymentArrayList;

    public Order() {
    }

    public Order( int id ) {
        this.id = id;
    }

    public Order( int id, ArrayList <Item> paymentArrayList ) {
        this.id = id;
        PaymentArrayList = paymentArrayList;
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
