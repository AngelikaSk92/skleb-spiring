package com.skleb_spring.service;

import com.skleb_spring.model.Delivery;
import com.skleb_spring.model.repository.DeliveryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DeliveryConverter implements Converter<String, Delivery> {

    @Autowired
    DeliveryDAO deliveryDAO;

    @Override
    public Delivery convert(String s) {
      Delivery delivery=  deliveryDAO.getDeliveryByName(s);
      return delivery;
    }
}
