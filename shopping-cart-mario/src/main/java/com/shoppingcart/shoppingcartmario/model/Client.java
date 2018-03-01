package com.shoppingcart.shoppingcartmario.model;

import lombok.Data;
import javax.persistence.*;


@Entity
@Table(name="client")
@Data public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)   //@GenericGenerator(strategy = GenerationType.AUTO)
    @Column(name="client_id")
    private int idClient;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="description")
    private String description;



}
