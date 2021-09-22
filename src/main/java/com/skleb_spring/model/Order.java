package com.skleb_spring.model;

import java.math.BigDecimal;
import java.util.Map;

public class Order {

    private static int orderNumber=0;
    private Cart cart;
    private BigDecimal amount;
    private Delivery delivery;

    public Order() {
        orderNumber++;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }


    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
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
