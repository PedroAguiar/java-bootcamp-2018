package com.bootcamp2018.control;

import com.bootcamp2018.dao.ItemDAO;
import com.bootcamp2018.model.Item;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

@Controller
@RequestMapping("/item")
public class ItemControl {


    @RequestMapping
    public Item create(Item object) {
        ItemDAO itemDAO = new ItemDAO();
        return itemDAO.createItem(object);
    }

    @RequestMapping(value="/")
    public ResponseEntity<Item> get(@RequestBody Item item) {
        ItemDAO itemDAO = new ItemDAO();
        item = itemDAO.retriveItem(item.getId());
        return new ResponseEntity<Item>(item,HttpStatus.OK);
    }

    public ArrayList<Item> getList(Item object) {
        ItemDAO itemDAO = new ItemDAO();
        return itemDAO.retriveItems(object);
    }


    public Item update(Item object) {
        ItemDAO itemDAO = new ItemDAO();
        return itemDAO.updateItem(object);
    }


    public void delete(Item object) {
        ItemDAO itemDAO = new ItemDAO();
        itemDAO.deleteItem(object);

    }
}
