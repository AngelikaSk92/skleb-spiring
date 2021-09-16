package com.skleb_spring.model;

import java.math.BigDecimal;

public class Item {

    private final String orderID;
    private final Product product;
    private final BigDecimal quantity;


    public Item(String orderID, Product product, BigDecimal quantity) {
        this.orderID = orderID;
        this.product = product;
        this.quantity = quantity;
    }

    public String getOrderID() {
        return orderID;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getAmount(){
        return product.getPrice().multiply(quantity);
    }
}
