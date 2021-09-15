package com.skleb_spring.controllers;

import com.skleb_spring.model.Product;
import com.skleb_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminControllers {

    @Autowired
    ProductService productService;

    @RequestMapping("/admin")
    public String addNewProduct(Model model){
        model.addAttribute("emptyProduct",new Product());
        return "productaddform";
    }


}
