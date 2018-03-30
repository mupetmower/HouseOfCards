package com.houseofcards.services;

import java.util.Optional;

import com.houseofcards.entities.Product;

public interface ProductService {
    Iterable<Product> listAllProducts();
    
    Product getProductById(Integer id);
 
    Product saveProduct(Product product);
    
    void deleteProduct(Integer id);
}
