package com.skleb_spring.model;

import java.math.BigDecimal;
import java.util.Map;

public class Order {

    private int orderNumber;
    private Map<Product, Integer> cart;
    private BigDecimal amount;
    private Delivery delivery;


    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", cart=" + cart
                 +
                ", amount=" + amount +
                ", delivery=" + delivery +
                '}';
    }
}
