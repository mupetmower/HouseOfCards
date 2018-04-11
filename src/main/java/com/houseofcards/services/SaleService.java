package com.houseofcards.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.houseofcards.entities.generated.Sale;
import com.houseofcards.repositories.SaleRepository;

public class SaleService implements CrudService<Sale> {
    
    public SaleRepository saleRepository;

    @Autowired
    public void setRepository(SaleRepository entityRepository) {
	this.saleRepository = entityRepository;	
    }

    @Override
    public Iterable<Sale> listAll() {
	return saleRepository.findAll();
    }

    @Override
    public Sale getById(Integer id) {
	return saleRepository.findById(id).get();
    }

    @Override
    public Sale save(Sale entity) {
	return saleRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
	saleRepository.deleteById(id);	
    }
    
    
}
