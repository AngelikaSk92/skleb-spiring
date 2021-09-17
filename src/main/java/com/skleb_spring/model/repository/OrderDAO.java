package com.skleb_spring.model.repository;

import com.skleb_spring.model.Delivery;
import com.skleb_spring.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class OrderDAO {

    private List<Order> orders = new ArrayList<>();

    @Autowired
    CartDAO cartDAO;

    @Autowired
    DeliveryDAO deliveryDAO;


    public int createUniqueOrderNumber(){
       if(!orders.isEmpty()) {
          return orders.stream().max(Comparator.comparing(v -> v.getOrderNumber())).get().getOrderNumber()+1;
       }
        return 1;
    }

    public Order createNewOrder(){
        Order order = new Order();
        order.setCart(cartDAO.getAllProductsFromCart());
        order.setAmount(cartDAO.getTotalFromCart());
        order.setOrderNumber(createUniqueOrderNumber());
        Delivery delivery=new Delivery();
        order.setDelivery(delivery);
        return order;
    }


    public Order getOrderByOrderNumber(int orderNumber) {
        for (Order order : orders){
            if(order.getOrderNumber()==orderNumber){
                return order;
            }
        }
        return null;
    }

    public void updateOrder(Order order) {
        orders.remove(getOrderByOrderNumber(order.getOrderNumber()));
        orders.add(order);
    }
}
