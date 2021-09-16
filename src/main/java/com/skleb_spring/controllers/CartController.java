package com.skleb_spring.controllers;

import com.skleb_spring.model.Product;
import com.skleb_spring.model.repository.CartDAO;
import com.skleb_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Map;

@Controller
public class CartController {

    @Autowired
    CartDAO cartDAO;

    @Autowired
    ProductService productService;

    @RequestMapping("/cart")
    public String showCart(Model model){
        Map<Product, Integer> listOfItemsFromCart=cartDAO.getAllProductsFromCart();
        BigDecimal total=cartDAO.getTotalFromCart();
        model.addAttribute("cart", listOfItemsFromCart);
        model.addAttribute("total", total);
        return "cart";
    }

    @RequestMapping("/cart/add/{name}")
    public String showCart(@PathVariable("name") String name){
        Product product = productService.getProductByName(name);
        cartDAO.addProductToCart(product,1);
        return "redirect:/cart";
    }


}
