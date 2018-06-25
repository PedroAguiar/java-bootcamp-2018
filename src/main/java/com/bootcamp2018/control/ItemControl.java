package com.bootcamp2018.control;

import com.bootcamp2018.dao.ItemDAO;
import com.bootcamp2018.model.Item;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@RestController
public class ItemControl {



    public Item create(Item object) {
        ItemDAO itemDAO = new ItemDAO();
        return itemDAO.createItem(object);
    }


    public Item get(Item Object) {
        return null;
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
