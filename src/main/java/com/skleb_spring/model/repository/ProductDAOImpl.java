package com.skleb_spring.model.repository;

import com.skleb_spring.model.Category;
import com.skleb_spring.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
@Component
public class ProductDAOImpl implements ProductDAO {
    private List<Product> products = Arrays.asList(
            new Product("Torebka MK", "Torebka Michael Kors - listonoszka", new BigDecimal("1025.00"), Category.ADDITIVES),
            new Product("Kolczyki", "Pozłacane kolczyki", new BigDecimal("29.99"), Category.ADDITIVES),
            new Product("Botki Damskie", "Czarne Botki na obcasie", new BigDecimal("229.99"), Category.SHOES),
            new Product("Spodnie jeansowe", "Spodnie jeansowe z kieszeniami", new BigDecimal("95.50"), Category.CLOTHES));


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



}
