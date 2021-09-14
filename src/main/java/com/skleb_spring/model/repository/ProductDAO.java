package com.skleb_spring.model.repository;

import com.skleb_spring.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> all();

    Product byName(String name);
}
