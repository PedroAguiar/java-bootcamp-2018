package com.bootcamp2018.control;

import java.util.ArrayList;

public interface Control<T> {
    T create(T object);

    T get(T object);

    ArrayList<T> getList(T object);

    T update(T object);

    void delete(T object);
}
