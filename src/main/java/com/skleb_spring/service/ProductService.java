package com.skleb_spring.service;

import com.skleb_spring.model.Product;
import com.skleb_spring.model.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.transform.AbstractProcessTask;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;

    public List<Product> getAllProducts(){
      return productDAO.all();
    }

    public Product getProductByName(String name){
        return productDAO.byName(name);
    }

}
