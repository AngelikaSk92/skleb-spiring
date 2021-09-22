package com.skleb_spring.model;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    @NotNull(message = "Nazwa produktu nie może być pusta")
    @Size(min=3, max=100, message = "długość nazwy produktu musi być pomiędzy 3 a 100 znaków")
    private String name;

    private String description;

    @NotNull(message = "pole z ceną musi być uzupełnione")
    @Min(value=0, message = "Cena nie może być mniejsza niż 0")
    @Max(value = 10000, message = "cena nie może przekroczyć 10000")
    private BigDecimal price;

    private Category category;


    public Product(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category=Category.INNE;
    }

    public Product(String name, String description, BigDecimal price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Product() {
        this.price=new BigDecimal(0);
        this.category=Category.INNE;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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



    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && category == product.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price, category);
    }
}
