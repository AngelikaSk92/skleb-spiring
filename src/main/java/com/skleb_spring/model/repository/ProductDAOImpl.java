package com.skleb_spring.model.repository;

import com.skleb_spring.model.Category;
import com.skleb_spring.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Component
public class ProductDAOImpl implements ProductDAO {
    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> all() {
        return products;
    }

    @Override
    public Product byName(String name) {
        for (Product product : products) {
            if (name.equals(product.getName())) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product createProductStringValues(String name, String description, double price, String category) {
        BigDecimal newPrice=new BigDecimal(price);
        Product product = new Product(name,description,newPrice,category);
        products.add(product);
        return product;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @PostConstruct
    public void buildShopDB(){
        addProduct(new Product("Torebka MK", "Torebka Michael Kors - listonoszka", new BigDecimal("1025.00"), "DODATKI"));
        addProduct(new Product("Kolczyki", "Pozłacane kolczyki", new BigDecimal("29.99"), "DODATKI"));
        addProduct(new Product("Botki damskie", "Czarne Botki na obcasie", new BigDecimal("229.99"), "OBUWIE"));
        addProduct(new Product("Kurtka pikowana", "Krótka kurtka pikowana z wysokim kołnierzem i długimi rękawami", new BigDecimal("249.99"), "UBRANIA"));
        addProduct(new Product("Golf damski", "Elegancki golf w pięknym kolorze. Wykonany z dobrej jakości materiału.", new BigDecimal("129.99"), "UBRANIA"));
        addProduct(new Product("Kozaki zamszowe", "Zamszowe obuwie na wyższej podeszwie w klasycznym kolorze.", new BigDecimal("189.99"), "OBUWIE"));
        addProduct(new Product("Bluzka koszulowa", "Elegancka koszula o prostym kroju w stonowanym, jednolitym kolorze. Wykonana z delikatnego materiału z połączeniem koronki.", new BigDecimal("119.99"), "UBRANIA"));
    }

}
