package com.globant.shoppingcartdemoapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;



@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private float amount;


    @OneToOne( cascade = CascadeType.ALL)
    private ShoppingOrder shoppingOrder;

    @ManyToOne
    private Client client;

    public Payment(){
        this.shoppingOrder = null;
    }

    @JsonIgnore
    public Client getClient(){
        return this.client;
    }


}
