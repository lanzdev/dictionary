package com.lanzdev.controllers.managers;

import java.util.List;

/**
 *
 * @param <T> is a type of object
 */
public interface Manager<T> {

    T add(T object);
    void update(T object);
    T getById(Integer id);
    List<T> getAll();
}
