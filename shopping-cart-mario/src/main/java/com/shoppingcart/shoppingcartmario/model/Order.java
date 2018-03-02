package com.shoppingcart.shoppingcartmario.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
// 'order' is a reserved word in h2 databases that's why I'm using 'pedido' instead
@Table(name = "PEDIDO")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer pedidoId;

}
