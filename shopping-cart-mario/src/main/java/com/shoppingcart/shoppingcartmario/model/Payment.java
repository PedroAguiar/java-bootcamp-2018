package com.shoppingcart.shoppingcartmario.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PAYMENT")
public class Payment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer paymentId;
}
