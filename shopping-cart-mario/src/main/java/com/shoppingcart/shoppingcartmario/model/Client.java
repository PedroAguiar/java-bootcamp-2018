package com.shoppingcart.shoppingcartmario.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer clientId;
    private String firstName;
    private String lastName;
    private String description;

}
