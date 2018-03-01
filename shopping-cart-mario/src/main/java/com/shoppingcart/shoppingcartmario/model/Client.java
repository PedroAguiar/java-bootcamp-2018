package com.shoppingcart.shoppingcartmario.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="clients")
@Data public class Client implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)   //@GenericGenerator(strategy = GenerationType.AUTO)
    @Column(name="idClient")
    private int id;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="description")
    private String description;



}
