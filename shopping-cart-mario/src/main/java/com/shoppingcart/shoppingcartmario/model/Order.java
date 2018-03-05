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
// 'order' is a reserved word in h2 databases that's why I'm using 'pedido' instead
@Table(name = "PEDIDO")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="ITEM_ID", foreignKey = @ForeignKey(name="Fk_Pedido_Item"))
    private List<Item> items;
}
