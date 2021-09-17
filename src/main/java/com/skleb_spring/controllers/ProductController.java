package com.skleb_spring.controllers;
import com.skleb_spring.model.Product;
import com.skleb_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;


    @RequestMapping("/product")
    public String getProductsDetails(@RequestParam(value = "name") String name,Model model){
        Product product= productService.getProductByName(name);
        model.addAttribute("product", product);
        return "desc";
    }

    @RequestMapping("/category")
    public String getProductsCategory(@RequestParam(value = "category") String category, Model model){
        String categoryName=productService.getCategoryByCategoryName(category);
        model.addAttribute("category", categoryName);
        List<Product> productList=productService.getProductListByCategoryName(category);
        model.addAttribute("productList", productList);
        return "category";
    }

    @RequestMapping(value = {"/category/list", "/"})
    public String getCategoryList(Model model){
        List<String> categoryList= productService.getCategoryUniqueStringName();
        model.addAttribute("categories", categoryList);
        return "categoryView";
    }


}
