package com.globant.model;

import javax.management.Descriptor;
import java.util.ArrayList;
import java.util.List;

public class Client { private int id;
    private String name;
    private String surname;
    private String description;
    private List<Payment> PaymentList = new ArrayList <Payment> ();

    public Client( String name, String surname, String description ) {
        this.name = name;
        this.surname = surname;
        this.description=description;

    }

    public Client( int id, String name, String surname, String description ) {
        this.id= id;
        this.name = name;
        this.surname = surname;
        this.description= description;
    }

    public Client( int id ) {
        this.id = id;
    }

    public Client( int id, String name, String surname, String description,List<Payment> PaymentList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.description = description;
        this.PaymentList = PaymentList;
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

    public List <Payment> getPaymentList() {
        return PaymentList;
    }

    public void setPaymentList( ArrayList <Payment> PaymentList ) {
        PaymentList = PaymentList;
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
