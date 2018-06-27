package com.globant.service;

import java.util.List;

public interface CRUD<T> {
    T create (T object) ;
    T read (int id );
    T update (T object);
    void delete(int id);
    List<T> readAll();
}
