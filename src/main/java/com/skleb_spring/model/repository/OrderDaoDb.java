package com.skleb_spring.model.repository;

import com.skleb_spring.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDaoDb extends CrudRepository<Order,Integer > {

}
