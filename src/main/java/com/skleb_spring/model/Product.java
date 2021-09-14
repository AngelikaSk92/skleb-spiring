package com.skleb_spring.model;

import java.math.BigDecimal;


public class Product {
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;


    public Product(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category=Category.OTHERS;
    }

    public Product(String name, String description, BigDecimal price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public void setCategory(Category category){
        this.category=category;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
