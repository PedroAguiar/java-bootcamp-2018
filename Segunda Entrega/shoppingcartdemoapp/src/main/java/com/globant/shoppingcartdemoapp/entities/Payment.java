package com.globant.shoppingcartdemoapp.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;



@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private float amount;


    @OneToOne
    private Order order;

    @ManyToOne
    private Client client;


}
