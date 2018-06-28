package com.globant.dao;

import com.globant.model.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDAO implements DataAccessObject<Item> {
    public Item create( Item object ) {
        return null;
    }

    public Item read( int id ) {
        return null;
    }

    public Item update( Item object ) {
        return null;
    }

    public void delete( int id ) {

    }

    public List<Item> readAll() {
        return null;
    }
}
