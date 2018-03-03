package com.globant.shoppingcartdemoapp.controller;

import com.globant.shoppingcartdemoapp.repository.*;
import com.globant.shoppingcartdemoapp.entities.*;
import com.globant.shoppingcartdemoapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;


    @RequestMapping(value="/item", method = RequestMethod.POST)
    public void addItem(@RequestBody Item item) {

        itemService.addItem(item);
    }

    @RequestMapping(value="/item/{itemId}", method = RequestMethod.GET)
    public Item getItem(@PathVariable int itemId) {

       return itemService.getItem(itemId);
    }

    @RequestMapping(value="/item/{itemId}",method = RequestMethod.DELETE)
    public void updateItem(@RequestBody Item item) {
        itemService.updateItem(item);
    }

    @RequestMapping(value="/item/{itemId}",method = RequestMethod.PUT)
    public void deleteItem(@PathVariable int itemId) {
        itemService.deleteItem(itemId);
    }


}
