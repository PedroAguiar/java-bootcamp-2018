package com.bootcamp2018.service;

import com.bootcamp2018.dao.ItemDAO;
import com.bootcamp2018.model.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemService implements Service<Item> {

    @Override
    public Item create(Item object) {
        ItemDAO itemDAO = new ItemDAO();
        return itemDAO.createItem(object);
    }

    @Override
    public Item get(Item Object) {
        return null;
    }

    @Override
    public ArrayList<Item> getList(Item object) {
        ItemDAO itemDAO = new ItemDAO();
        return itemDAO.retriveItems(object);
    }

    @Override
    public Item update(Item object) {
        ItemDAO itemDAO = new ItemDAO();
        return itemDAO.updateItem(object);
    }

    @Override
    public void delete(Item object) {
        ItemDAO itemDAO = new ItemDAO();
        itemDAO.deleteItem(object);

    }
}
