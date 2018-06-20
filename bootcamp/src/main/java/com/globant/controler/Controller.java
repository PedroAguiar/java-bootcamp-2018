package com.globant.controler;

import java.util.List;

public interface Controller <T>{
    public T create (T object) ;
    public T read (int id );
    public T update (T object);
    public void delete(int id);

    public List<T> readAll();
}
