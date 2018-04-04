package com.houseofcards.services;

public interface CrudService<T> {
    Iterable<T> listAll();
    
    T getById(Integer id);
 
    T save(T entity);
    
    void delete(Integer id);
}
