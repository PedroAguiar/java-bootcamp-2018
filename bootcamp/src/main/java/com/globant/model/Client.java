package com.globant.model;

import java.util.ArrayList;

public class Client { private int id_client;
    private String name;
    private String surmane;
    private String description;

    private ArrayList<Payment> PaymentArrayList;

    public Client(int id_client, String name, String surname, String descriprion ){
        this.id_client = id_client;
        this.name = name;
        this.surmane = surname;
        this.description = description;


    }

    public void setId( int id_cliente ) {
        this.id_client = id_client;
    }

    public int getId() {
        return this.id_client;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurmane( String surmane ) {
        this.surmane = surmane;
    }

    public String getSurmane() {
        return surmane;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }



    @Override
    public String toString() {
        return "Client{" +
                "id_client" + id_client +
                ", name='" + name + '\'' +
                ", surmane='" + surmane + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
