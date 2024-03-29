package com.skleb_spring.controllers;

import com.skleb_spring.model.Order;
import com.skleb_spring.model.Product;
import com.skleb_spring.model.repository.OrderDAO;
import com.skleb_spring.model.repository.OrderDaoDb;
import com.skleb_spring.service.ProductService;
import com.skleb_spring.service.ProductServiceDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminControllers {

    @Autowired
    ProductServiceDb productService;

    @Autowired
    OrderDaoDb orderDAO;

    @GetMapping("/category/admin")
    public String addNewProduct(Model model){
        model.addAttribute("emptyProduct",new Product());
        return "productaddform";
    }

    @RequestMapping("/admin/products/list")
    public String getProductsList(Model model){
        List<Product> products =productService.findAll();
        model.addAttribute("products", products);
        return "prod";
    }

    @RequestMapping(value = "/admin/products/list", method = RequestMethod.POST)
    public String createNewProduct(@Valid @ModelAttribute("emptyProduct") Product product, BindingResult  bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println("ERROR");
            bindingResult.getAllErrors().forEach(e->{
                System.out.println(e.getDefaultMessage());
            });
            return "productaddform";
        }else {
            productService.save(product);
            return "redirect:/admin/products/list";
        }


    }
    @RequestMapping("/product/delete/{name}")
    public String deleteProduct(@PathVariable("name") String name){
        productService.deleteProduct(name);
        return "redirect:/admin/products/list";
    }

    @RequestMapping("product/edit/{name}")
    public String editProduct(@PathVariable("name") String name, Model model){
        Product product = productService.getProductByName(name);
        productService.deleteProduct(name);
        model.addAttribute("productToEdit", product);
        model.addAttribute("nameToLink", name);
        return "editform";
    }

    @RequestMapping(value = "product/edit/{name}", method = RequestMethod.POST)
    public String updateProduct(@PathVariable("name") String name, @ModelAttribute ("productToEdit") Product product){
        productService.updateProduct(product);
        return "redirect:/admin/products/list";
    }

    @RequestMapping(value = "admin/orders")
    public String seeAllOrders(Model model){

        //List<Order> orders= orderDAO.getAllOrders();
       // model.addAttribute("orders", orders);


        return "orders";
    }




}
