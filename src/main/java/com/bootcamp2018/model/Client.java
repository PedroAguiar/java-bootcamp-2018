package com.bootcamp2018.model;

import java.util.ArrayList;

public class Client {
    private int id;
    private String name;
    private String lastName;
    private String description;
    private ArrayList<Payment> Payments;

    public Client(int id) {
        this.id = id;
        this.name = "";
        this.lastName = "";
        this.description = "";
        this.Payments = new ArrayList<Payment>();
    }

    public Client(int id, String name, String lastName, String description) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.description = description;
        Payments = new ArrayList<Payment>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return Payments;
    }

    public void setPayments(ArrayList<Payment> payments) {
        Payments = payments;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Client.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Client other = (Client) obj;

        if (this.getId() != other.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String str;
        str = "Name: "+ getName()+ ". Last name: "+ getLastName();
        str += "\nDescription: "+getDescription();
        if (getPayments().size() >0) {
            for (Payment p : getPayments()
                 ) {
                str +="\n" +p.toString();
            }
        } else {
            str +="\nNo payments";
        }
        return str;


    }
}
