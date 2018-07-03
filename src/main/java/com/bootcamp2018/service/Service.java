package com.bootcamp2018.service;

import java.util.ArrayList;

public interface Service<T> {
    T create(T object);

    T get(T object);

    ArrayList<T> getList(T object);

    T update(T object);

    void delete(T object);
}
