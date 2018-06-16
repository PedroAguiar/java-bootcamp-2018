package com.bootcamp2018.service;

import com.bootcamp2018.dao.ItemDAO;
import com.bootcamp2018.model.Item;
import java.util.ArrayList;

public class ItemService implements Service<Item> {

    @Override
    public Item create(Item Object) {
        ItemDAO itemDAO = new ItemDAO();
        return itemDAO.createItem(Object);
    }

    @Override
    public Item get(Item Object) {
        return null;
    }

    @Override
    public ArrayList<Item> getList(Item Object) {
        return null;
    }

    @Override
    public Item update(Item Object) {
        return null;
    }

    @Override
    public void delete(Item Object) {

    }
}
