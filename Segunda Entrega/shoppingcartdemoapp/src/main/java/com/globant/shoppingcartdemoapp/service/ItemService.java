package com.globant.shoppingcartdemoapp.service;


import com.globant.shoppingcartdemoapp.entities.Item;
import com.globant.shoppingcartdemoapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void addItem(Item item) {
        itemRepository.save(item);
    }

    public Item getItem(int itemId) {
       return itemRepository.findById(itemId);
    }


    public void updateItem(Item item) {
        itemRepository.save(item);
    }

    public void deleteItem(int itemId) {
        itemRepository.deleteById(itemId);
    }
}
