package com.skleb_spring.controllers;

import com.skleb_spring.model.Product;
import com.skleb_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminControllers {

    @Autowired
    ProductService productService;

    @RequestMapping("/category/admin")
    public String addNewProduct(Model model){
        model.addAttribute("emptyProduct",new Product());
        return "productaddform";
    }

    @RequestMapping("/category/admin/products/list")
    public String getProductsList(Model model){
        List<Product> products =productService.getAllProducts();
        model.addAttribute("products", products);
        return "prod";
    }

    @RequestMapping(value = "/category/admin/products/list", method = RequestMethod.POST)
    public String createNewProduct(@Valid  @ModelAttribute("emptyProduct") Product product, BindingResult  bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println("ERROR");
            bindingResult.getAllErrors().forEach(e->{
                System.out.println(e.getDefaultMessage());
            });
            return "productaddform";
        }else {
            productService.saveNewProduct(product);
            return "redirect:/category/admin/products/list";
        }


    }

    @RequestMapping("/product/delete/{name}")
    public String deleteProduct(@PathVariable("name") String name){
        productService.deleteProduct(name);
        return "redirect:/category/admin/products/list";
    }


}
