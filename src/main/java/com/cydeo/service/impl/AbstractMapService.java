package com.cydeo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapService <T,ID>{//spr

    //save in database map(if we have key and value)
    public Map<ID,T> map=new HashMap<>();//DB//we created abstract class because we don't need to create objects just methode
    T save(ID id,T object){     //save is accepting object and returning object
    map.put(id,object);       //All business logic created
     return object;

    }
    List<T> findAll(){
        return new ArrayList<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    void deleteById(ID id){
        map.remove(id);
    }

}
