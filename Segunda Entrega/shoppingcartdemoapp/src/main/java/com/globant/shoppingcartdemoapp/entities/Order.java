package com.globant.shoppingcartdemoapp.entities;


import lombok.Data;
import java.util.*;


import javax.persistence.*;


@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;


    @OneToMany
    private List<Item> items;

    public Order(){
        this.items = new LinkedList<>();
    }

}
