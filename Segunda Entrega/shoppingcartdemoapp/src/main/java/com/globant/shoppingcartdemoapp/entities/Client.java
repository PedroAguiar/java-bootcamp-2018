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
    private String desription;

    @OneToMany
    private List<Payment> payments;

    public Client() {
        this.payments = new ArrayList<>();
    }
}
