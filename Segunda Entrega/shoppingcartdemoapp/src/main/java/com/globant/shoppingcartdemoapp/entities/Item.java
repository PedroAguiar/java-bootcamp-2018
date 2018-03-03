package com.globant.shoppingcartdemoapp.entities;


import lombok.Data;


import javax.persistence.*;


@Entity
@Data
public class Item {



    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;

    @OneToOne
    private Order order;



}
