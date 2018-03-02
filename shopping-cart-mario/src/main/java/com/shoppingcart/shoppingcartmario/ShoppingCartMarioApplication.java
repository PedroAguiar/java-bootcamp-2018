package com.shoppingcart.shoppingcartmario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class ShoppingCartMarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartMarioApplication.class, args);
	}
}
