package com.shoppingcart.shoppingcartmario.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ITEM")
public class Item {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Order pedido;
}
