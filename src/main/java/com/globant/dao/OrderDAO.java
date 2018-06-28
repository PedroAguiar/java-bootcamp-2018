package com.globant.dao;

import com.globant.model.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAO implements DataAccessObject<Client> {
    public Client create( Client object ) {
        return null;
    }

    public Client read( int id ) {
        return null;
    }

    public Client update( Client object ) {
        return null;
    }

    public void delete( int id ) {

    }

    public List<Client> readAll() {
        return null;
    }
}
