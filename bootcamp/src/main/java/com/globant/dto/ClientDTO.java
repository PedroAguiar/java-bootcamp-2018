package com.globant.dto;

import com.globant.model.Payment;

import java.util.ArrayList;

public class ClientDTO {
    private String id;
    private String name;
    private String surmane;
    private String description;
    private ArrayList<Payment> PaymentArrayList;

    public ClientDTO() {
    }

    public ClientDTO( String id ) {
        this.id = id;
    }

    public ClientDTO( String id, String name, String surmane, String description, ArrayList<Payment> paymentArrayList ) {
        this.id = id;
        this.name = name;
        this.surmane = surmane;
        this.description = description;
        PaymentArrayList = paymentArrayList;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurmane() {
        return surmane;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Payment> getPaymentArrayList() {
        return PaymentArrayList;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public void setSurmane( String surmane ) {
        this.surmane = surmane;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public void setPaymentArrayList( ArrayList<Payment> paymentArrayList ) {
        PaymentArrayList = paymentArrayList;
    }
}
