package com.globant.dao;

import java.util.List;

public interface DataAccessObject<T>{
    T create(T object);
    T read(int id );
    T update(T object);
    void delete(int id);
    List<T> readAll();
}
