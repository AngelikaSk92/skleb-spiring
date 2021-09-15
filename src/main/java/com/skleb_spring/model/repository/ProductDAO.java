package com.skleb_spring.model.repository;

import com.skleb_spring.model.Category;
import com.skleb_spring.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductDAO {
    List<Product> all();

    Product byName(String name);

    Product createProductStringValues(String name, String description, double price, String category);

    void addProduct(Product product);


}
