package com.shoppingcart.shoppingcartmario.service.impl;

import com.shoppingcart.shoppingcartmario.model.Item;
import com.shoppingcart.shoppingcartmario.repository.ItemRepository;
import com.shoppingcart.shoppingcartmario.service.ItemService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item createItem(Item item) {
        Validate.isTrue(!itemExists(item.getName()));
        return itemRepository.save(item);
    }

    @Override
    public Item getItem(Integer itemId) {
        Validate.isTrue(itemExists(itemId));
        return itemRepository.getOne(itemId);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    //We need this to be transactional because of the @Modifying query
    @Transactional
    public void updateItem(Item item) {
        Validate.isTrue(itemExists(item.getId()));
        itemRepository.update(item.getName(), item.getId());
    }

    @Override
    public void deleteItem(Integer idItem) {
        itemRepository.deleteById(idItem);
    }


    private boolean itemExists(String name) {
        return itemRepository.findByName(name) != null;
    }

    private boolean itemExists(Integer itemId) {
        return itemRepository.findById(itemId).isPresent();
    }
}
