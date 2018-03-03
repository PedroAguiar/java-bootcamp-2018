package com.globant.shoppingcartdemoapp.entities;


import lombok.Data;
import java.util.*;


import javax.persistence.*;


@Entity
@Data
public class ShoppingOrder {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;


    @OneToMany( cascade = CascadeType.ALL)
    private List<Item> item;

    public ShoppingOrder(){
        this.item = new LinkedList<>();
    }

}
