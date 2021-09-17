package com.skleb_spring.model.repository;

import com.skleb_spring.model.Delivery;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Component
public class DeliveryDAO {

    private List<Delivery> deliveryOptions = new ArrayList<>();

    @PostConstruct
    public void buildDeliveryOptions(){
        deliveryOptions.add(new Delivery("PRZESYŁkA KURIERSKA DPD-PRZEDPŁATA", new BigDecimal(18)));
        deliveryOptions.add(new Delivery("PRZESYLkA KURIERSKA DPD-POBRANIE", new BigDecimal(25)));
        deliveryOptions.add(new Delivery("PACZKOMAT IN-POST", new BigDecimal(8)));
        deliveryOptions.add(new Delivery("ODBIÓR OSOBISTY", new BigDecimal(0)));
    }

    public Delivery getDeliveryByName(String deliveryName){
        for(Delivery d: deliveryOptions){
            if(d.equals(deliveryName)){
                return d;
            }
        }
        return new Delivery("NIEZNANA OPCJA DOSTAWY", new BigDecimal(0));
    }

    public List<Delivery> getDeliveryOptions() {
        return deliveryOptions;
    }
}
