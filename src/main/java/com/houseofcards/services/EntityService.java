package com.houseofcards.services;

public interface EntityService<T, R> extends CrudService<T> {
    
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
