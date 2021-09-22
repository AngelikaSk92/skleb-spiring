package com.skleb_spring.service;

import com.skleb_spring.model.Cart;
import com.skleb_spring.model.Product;
import com.skleb_spring.model.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
@Component
public class CartConverter implements Converter<String, Cart> {
    @Autowired
    ProductDAO productDAO;
    @Override
    public Cart convert(String s) {
        Map<Product,Integer> cart =new HashMap<>();

        s=s.substring(1,s.length()-1);
        String temp="";
        int tempInt=0;
        int occurrence=0;
        while(s.indexOf("=")!=-1){
            occurrence=s.indexOf("=");
            temp=s.substring(0,occurrence);
            tempInt=Integer.parseInt(s.substring(occurrence+1,occurrence+2));
            cart.put(productDAO.byName(temp),tempInt);
            s=s.substring(occurrence+4>s.length()?s.length():occurrence+4);
        }
        Cart retrivedCart=new Cart(cart);

        return retrivedCart;
    }
}
