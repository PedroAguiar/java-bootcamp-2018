package com.globant.model;

public class Client { private int id;
    private String name;
    private String surmane;
    private String description;
    private Payment payment;

    public Client(int id, String name, String surname, String descriprion, Payment pyment){
        this.id = id;
        this.name = name;
        this.surmane = surname;
        this.description = description;
        this.payment = payment;

    }

    public void setId( int id ) {
        this.id = id;
    }

    public int getId() {
        return id;
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

    public void setPayment( Payment payment ) {
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }
}
