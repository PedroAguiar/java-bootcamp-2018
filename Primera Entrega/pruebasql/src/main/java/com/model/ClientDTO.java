package com.model;

import java.sql.SQLException;
import java.util.ArrayList;


public class ClientDTO {

    private int ID;
    private String name;
    private String lastName;
    private String description;
    private ArrayList<Payment> payments;



    public ClientDTO(String name, String lastName, String description) {
        this.name = name;
        this.lastName = lastName;
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "Client ID: " +
                ID + "\nName: " + name + "\nLast Name: " + lastName
                + "\nDescription: "+ description + "\n-------------------------\n" +
                "";
    }


}
