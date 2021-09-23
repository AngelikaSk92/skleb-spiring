package com.skleb_spring.model.repository;

import com.skleb_spring.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDaoDb extends CrudRepository<Product, String> {
    List<Product> findByCategory(String category);
    @Query
    List<Product> retrieveAllProducts();
}
