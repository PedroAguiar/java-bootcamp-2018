package com.shoppingcart.shoppingcartmario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private Integer id;
    private Integer clientId;
    private String amount;
    private Integer pedidoId;

}
