package com.cydeo.service;

import java.util.List;

public interface CrudService <T, ID>{//all fields are unique
    T save (T user);
    T findById(ID username);
    List<T> findAll();
    void deleteById(ID username);

    void update(T object);


}
