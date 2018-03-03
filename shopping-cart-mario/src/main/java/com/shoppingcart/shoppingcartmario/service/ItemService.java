package com.shoppingcart.shoppingcartmario.service;

import com.shoppingcart.shoppingcartmario.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();
    Item getItem(Integer idItem);
    Item createItem(Item item);
    void updateItem(Item item);
    void deleteItem(Integer idItem);
}
