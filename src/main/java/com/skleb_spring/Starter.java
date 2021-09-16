package com.skleb_spring;

import com.skleb_spring.model.Category;
import com.skleb_spring.model.Product;
import com.skleb_spring.model.repository.CartDAO;
import com.skleb_spring.model.repository.ProductDAO;
import com.skleb_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    ProductService productService;


    @Autowired
    ProductDAO productDAO;

    @Autowired
    CartDAO cartDAO;


    @Override
    public void run(String... args) throws Exception {
//        Map<Category, List<Product>> listOfCategory = productService.getProductsByCategory();
//        for (Map.Entry<Category, List<Product>> categoryListMap : listOfCategory.entrySet()) {
//            System.out.println(categoryListMap.getKey());
//            for (Product p : categoryListMap.getValue()) {
//                System.out.println(p.toString());
//            }
//        }


        Product product = new Product("TEST", "TEST TEST", new BigDecimal(1000), Category.UBRANIA);

//        cartDAO.addProductToCart(product, 1);
//        cartDAO.addProductToCart(product, 1);
//        cartDAO.addProductToCart(product, 1);
//        Product product1 = productService.getProductByName("Torebka MK");
//        cartDAO.addProductToCart(product1,1);
//        for(Map.Entry<Product,Integer> entry: cartDAO.getAllProductsFromCart().entrySet()){
//            System.out.println(entry.getKey().toString());
//            System.out.println(entry.getValue());
//        }


    }
}
