package com.shoppingcart.shoppingcartmario.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String description;
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(foreignKey = @ForeignKey(name="Fk_Client_Payments"), name="client_id")
    private List<Payment> payments;
}
