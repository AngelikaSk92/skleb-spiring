package com.skleb_spring.model;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
@Embeddable
public class Delivery {

    private String deliveryName;
    private BigDecimal deliveryPrice;

    public Delivery(String deliveryName, BigDecimal deliveryPrice) {
        this.deliveryName = deliveryName;
        this.deliveryPrice = deliveryPrice;
    }

    public Delivery() {
        this.deliveryName="ODBIÓR OSOBISTY";
        this.deliveryPrice=new BigDecimal(0);
    }



    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryName='" + deliveryName + '\'' +
                ", deliveryPrice=" + deliveryPrice +
                '}';
    }
}
