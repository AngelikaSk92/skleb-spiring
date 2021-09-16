package com.skleb_spring.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public BigDecimal getTotal(){
        BigDecimal total =BigDecimal.ZERO;
        for(Item i : items){
            total=total.add(i.getAmount());
        }
        return total;
    }





}
