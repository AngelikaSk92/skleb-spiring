package com.skleb_spring.service;

import com.skleb_spring.model.Product;
import com.skleb_spring.model.repository.ProductDaoDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceDb {

    @Autowired
    ProductDaoDb productDaoDb;


    public Product getProductByName(String name) {
      Optional<Product> product= productDaoDb.findById(name);
      return product.get();
    }

    public List<Product> getProductListByCategoryName(String category) {
        List<Product> listOfProductsByCategory=productDaoDb.findByCategory(category);
        return listOfProductsByCategory;
    }

    public List<String> getCategoryUniqueListName() {
        List<Product> products= productDaoDb.retrieveAllProducts();
        List<String> categories = new ArrayList<>();
        for(Product p: products){
            if(!categories.contains(p.getCategory())){
                categories.add(p.getCategory());
            }
        }
        return categories;
    }

    public void save(Product product) {
        productDaoDb.save(product);
    }

    public List<Product> findAll() {
       return productDaoDb.retrieveAllProducts();
    }

    public void deleteProduct(String name) {
        productDaoDb.deleteById(name);
    }

    public void updateProduct(Product product) {
        productDaoDb.save(product);

    }
}
