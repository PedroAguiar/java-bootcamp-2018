package com.shoppingcart.shoppingcartmario.controller;

import com.shoppingcart.shoppingcartmario.model.Item;
import com.shoppingcart.shoppingcartmario.service.ItemService;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//This is a convenience annotation that provides the @Controller & @ResponseBody functionalities
@RestController
public class ItemController {

    //This creates a Logger Object
    // that will be taking care of doing what you did with 'System.out.prinln statements' a.k.a 'logging'
    private Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    //@RequestMapping(value = "/item")
    @GetMapping(value = "/item/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getItemById(@PathVariable("id") Integer id) {
        Item item = itemService.getItem(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> list = itemService.getAllItems();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/item", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> addItem(@RequestBody Item item) {

        //Logging example, the value of '{}' gets filled with the output of item.toString()
        LOGGER.info("Adding item {} ", item.toString());

        System.out.println("item/// --> " + item.toString());

        final Item persistedItem = itemService.createItem(item);
        Validate.notNull(persistedItem);

        return new ResponseEntity<>(persistedItem, HttpStatus.CREATED);
    }

    @PutMapping(value = "/item", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
        itemService.updateItem(item);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/item/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteItem(@PathVariable("id") Integer id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
