package com.globant.shoppingcartdemoapp.repository;

import com.globant.shoppingcartdemoapp.entities.*;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item,Integer> {

    Item findById(int itemId);
}
