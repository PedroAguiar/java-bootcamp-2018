package com.shoppingcart.shoppingcartmario.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ITEM")
public class Item {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer itemId;
}
