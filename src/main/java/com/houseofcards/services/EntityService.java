package com.houseofcards.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.houseofcards.entities.Entity;
import com.houseofcards.repositories.EntityRepository;

public abstract interface EntityService<T, R> extends CrudService<T> {
    
    //public EntityRepository<T> entityRepository;
    
    
    public void setRepository(R entityRepository);

    @Override
    public Iterable<T> listAll();

    @Override
    public T getById(Integer id);

    @Override
    public T save(T entity);

    @Override
    public void delete(Integer id);
    
    
}
