package com.skleb_spring.controllers;

import com.skleb_spring.model.Product;
import com.skleb_spring.model.repository.ProductDAO;
import com.skleb_spring.model.repository.ProductDAOImpl;
import com.skleb_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/products/list")
    public String getProductsList(Model model){
        List<Product> products =productService.getAllProducts();
        model.addAttribute("products", products);
        return "prod";
    }

    @RequestMapping("/products/details")
    public String getTest(Model model){
        List<Product> products =productService.getAllProducts();

        return "desc";
    }


}
