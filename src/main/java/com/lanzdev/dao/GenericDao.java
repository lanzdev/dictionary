package com.lanzdev.dao;

import java.util.List;

public interface GenericDao<T> {

    T create(T object);

    T get(int key);

    List<T> getAll( );

    void update(T object);

    void delete(T object);
}
