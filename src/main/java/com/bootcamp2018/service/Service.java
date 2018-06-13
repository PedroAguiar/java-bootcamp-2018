package com.bootcamp2018.service;

import java.util.ArrayList;

public interface Service<T> {
    T create(T Object);
    T get(T Object);
    ArrayList<T> getList(T Objact);
    T update(T Object);
    T delete(T Object);
}
