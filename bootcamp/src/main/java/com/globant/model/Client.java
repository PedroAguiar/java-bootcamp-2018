package com.globant.model;

import java.util.ArrayList;

public class Client { private int id;
    private String name;
    private String surname;
    private String description;
    private ArrayList<Payment> PaymentArrayList;

    public Client() {
    }

    public Client( int id ) {
        this.id = id;
    }

    public Client( int id, String name, String surname, String description, ArrayList <Payment> paymentArrayList ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.description = description;
        PaymentArrayList = paymentArrayList;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname( String surname ) {
        this.surname =surname ;
    }

    public String getSurname() {
        return surname;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList <Payment> getPaymentArrayList() {
        return PaymentArrayList;
    }

    public void setPaymentArrayList( ArrayList <Payment> paymentArrayList ) {
        PaymentArrayList = paymentArrayList;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id_client" + id +
                ", name='" + name + '\'' +
                ", surmane='" + surname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
