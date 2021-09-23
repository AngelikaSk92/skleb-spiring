package com.skleb_spring.controllers;

import com.skleb_spring.model.Order;
import com.skleb_spring.model.Product;
import com.skleb_spring.model.repository.CartDAO;
import com.skleb_spring.model.repository.DeliveryDAO;
import com.skleb_spring.model.repository.OrderDAO;
import com.skleb_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.util.Map;

@Controller
public class CartController {

    @Autowired
    CartDAO cartDAO;

    @Autowired
    ProductService productService;

    @Autowired
    OrderDAO orderDAO;


    @Autowired
    DeliveryDAO deliveryDAO;

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

    @RequestMapping("/cart/delete/{name}")
    public String deleteProductFromCart(@PathVariable("name") String name){
        Product product = productService.getProductByName(name);
        cartDAO.deleteProductFromCart(product);
        return "redirect:/cart";
    }

    @RequestMapping("/cart/delete")
    public String deleteAllProductsFromCart(){
        cartDAO.deleteAllProducts();
        return "redirect:/cart";
    }

    @RequestMapping("/cart/order")
    public String createNewOrder(Model model){
        Order order = orderDAO.createNewOrder();
        model.addAttribute("order", order);
        model.addAttribute("cartValue",cartDAO.getTotalFromCart());
        model.addAttribute("deliveryOptions",deliveryDAO.getDeliveryOptions());
        return "neworderform";
    }

    @RequestMapping(value = "/cart/order", method = RequestMethod.POST)
    public String choseDelivery(@ModelAttribute("orderId") Order order){
        orderDAO.updateOrder(order);
        return "redirect:/cart/order";
    }

    @RequestMapping(value = "/cart/order/{orderNumber}")
    public String finishDelivery(@PathVariable("orderNumber") int orderNumber,  Model model){

        return "orderfinishpage";
    }








}
