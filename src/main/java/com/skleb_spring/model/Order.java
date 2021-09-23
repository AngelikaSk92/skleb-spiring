package com.skleb_spring.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Map;
@Entity
@Table(name = "ORDERS_TABLE")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int orderNumber=0;

    @ElementCollection
    @CollectionTable(
            name = "order_item",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "orderNumber")}
    )
    @MapKeyColumn(name = "item_name")
    @Column(name = "quantity")
    private Map<Product, Integer> cart;
    private BigDecimal amount;
    @Embedded
    private Delivery delivery;

    public Order() {
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
