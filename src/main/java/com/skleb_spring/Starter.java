package com.skleb_spring;

import com.skleb_spring.model.Category;
import com.skleb_spring.model.Product;
import com.skleb_spring.model.repository.CartDAO;
import com.skleb_spring.model.repository.OrderDAO;
import com.skleb_spring.model.repository.ProductDAO;
import com.skleb_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    ProductService productService;


    @Autowired
    ProductDAO productDAO;

    @Autowired
    CartDAO cartDAO;

    @Autowired
    OrderDAO orderDAO;


    @Override
    public void run(String... args) throws Exception {
//        Map<Category, List<Product>> listOfCategory = productService.getProductsByCategory();
//        for (Map.Entry<Category, List<Product>> categoryListMap : listOfCategory.entrySet()) {
//            System.out.println(categoryListMap.getKey());
//            for (Product p : categoryListMap.getValue()) {
//                System.out.println(p.toString());
//            }
//        }


        Product product = new Product("TEST", "TEST TEST", new BigDecimal(1000), "UBRANIA");

        cartDAO.addProductToCart(product, 1);
        cartDAO.addProductToCart(product, 1);
        cartDAO.addProductToCart(product, 1);
        Product product1 = productService.getProductByName("Torebka MK");
        cartDAO.addProductToCart(product1,1);


        System.out.println(cartDAO.getAllProductsFromCart().toString());
  //      Order order = orderDAO.createNewOrder();
  //      order.toString();
//        Order order = new Order();
//        order.setCart(cartDAO.getAllProductsFromCart());
//        order.setAmount(cartDAO.getTotalFromCart());
//        order.setOrderNumber(orderDAO.createUniqueOrderNumber());
//
//        System.out.println(order.getAmount());
//        System.out.println(order.getOrderNumber());


   //     System.out.println(orderDAO.getOrderByOrderNumber(1));





    }
}
