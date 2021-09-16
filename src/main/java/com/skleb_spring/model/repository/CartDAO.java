package com.skleb_spring.model.repository;

import com.skleb_spring.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartDAO {

    Map<Product, Integer> cart=new HashMap<>();

    public void addProductToCart(Product product, Integer quantity){
        if(cart.containsKey(product)){
            cart.put(product,cart.get(product) + quantity);
        }else{
            cart.put(product,quantity);
        }
    }

    public Map<Product,Integer> getAllProductsFromCart(){
        return cart;
    }

    public BigDecimal getTotalFromCart(){
        BigDecimal total=BigDecimal.ZERO;
        for(Map.Entry<Product,Integer> entry : cart.entrySet()){
            BigDecimal quantity = new BigDecimal(entry.getValue());
            total= total.add(entry.getKey().getPrice().multiply(quantity));
        }
        return total;
    }

    public BigDecimal getTotalFromOneProduct(Product product, Integer integer){
        BigDecimal quantity=new BigDecimal(integer);
        return product.getPrice().multiply(quantity);
    }




}
