package com.globant.shoppingcartdemoapp.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.*;


@Entity
@Data
public class Client {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private String lastName;
    private String description;

    @OneToMany( cascade = CascadeType.ALL)
    private List<Payment> payment;

    public Client() {
        this.payment = new ArrayList<>();
    }

    public String toString() {
        return "";
    }
}
