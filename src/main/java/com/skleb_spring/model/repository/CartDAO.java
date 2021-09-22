package com.skleb_spring.model.repository;

import com.skleb_spring.model.Cart;
import com.skleb_spring.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartDAO {

    Cart cart=new Cart(new HashMap<>());

    public void addProductToCart(Product product, Integer quantity){
        if(cart.getCart().containsKey(product)){
            cart.getCart().put(product,cart.getCart().get(product) + quantity);
        }else{
            cart.getCart().put(product,quantity);
        }
    }


    public Cart getAllProductsFromCart(){
        return cart;
    }

    public BigDecimal getTotalFromCart(){
        BigDecimal total=BigDecimal.ZERO;
        for(Map.Entry<Product,Integer> entry : cart.getCart().entrySet()){
            BigDecimal quantity = new BigDecimal(entry.getValue());
            total= total.add(entry.getKey().getPrice().multiply(quantity));
        }
        return total;
    }

    public BigDecimal getTotalFromOneProduct(Product product, Integer integer){
        BigDecimal quantity=new BigDecimal(integer);
        return product.getPrice().multiply(quantity);
    }


    public void deleteProductFromCart(Product product) {
        if(cart.getCart().containsKey(product))  cart.getCart().remove(product);
    }

    public void deleteAllProducts() {
        cart.getCart().clear();
    }
}
