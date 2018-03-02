package com.shoppingcart.shoppingcartmario.repository;

import com.shoppingcart.shoppingcartmario.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

//See how I provided the Type of the repository 'Item' and the type of it's id
public interface ItemRepository extends JpaRepository<Item, Long> {
}
