package com.cydeo.service;

import java.util.List;

public interface CrudService <T, ID>{//Created generics interface because we will have more services with same methode and different parameters - fields are unique
    T save (T user);
    T findById(ID username);
    List<T> findAll();
    void deleteById(ID username);

    void update(T object);


}
