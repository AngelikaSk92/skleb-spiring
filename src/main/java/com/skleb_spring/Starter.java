package com.skleb_spring;

import com.skleb_spring.model.Category;
import com.skleb_spring.model.Product;
import com.skleb_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    ProductService productService;



    @Override
    public void run(String... args) throws Exception {
        Map<Category, List<Product>> listOfCategory = productService.getProductsByCategory();
        for (Map.Entry<Category, List<Product>> categoryListMap : listOfCategory.entrySet()) {
            System.out.println(categoryListMap.getKey());
            for (Product p : categoryListMap.getValue()) {
                System.out.println(p.toString());
            }
        }

        System.out.println(productService.getCategoryByCategoryName("UBRANIA") instanceof String);

    }
}