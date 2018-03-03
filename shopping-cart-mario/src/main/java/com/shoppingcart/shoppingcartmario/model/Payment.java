package com.shoppingcart.shoppingcartmario.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "PAYMENT")
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String amount;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="PEDIDO_ID", foreignKey = @ForeignKey(name="Fk_Payment_Pedido"))
    private Order order;

//    public Payment(String amount, Client client, Order pedido) {
//        this.amount = amount;
//        this.client = client;
//        this.pedido = pedido;
//    }
}
