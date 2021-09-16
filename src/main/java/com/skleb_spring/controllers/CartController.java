package com.skleb_spring.controllers;

import com.skleb_spring.model.Category;
import com.skleb_spring.model.Product;
import com.skleb_spring.model.repository.CartDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Map;

@Controller
public class CartController {

    @Autowired
    CartDAO cartDAO;

    @RequestMapping("/cart")
    public String showCart(Model model){
        Map<Product, Integer> listOfItemsFromCart=cartDAO.getAllProductsFromCart();
        Product product=new Product("Torebka", "bla bla ", new BigDecimal(1005), Category.UBRANIA);
        cartDAO.addProductToCart(product, 10);
        BigDecimal total=cartDAO.getTotalFromCart();
        model.addAttribute("cart", listOfItemsFromCart);
        model.addAttribute("total", total);
        return "cart";
    }


}
