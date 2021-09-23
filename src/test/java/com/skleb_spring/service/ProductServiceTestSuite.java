package com.skleb_spring.service;


import com.skleb_spring.model.Category;
import com.skleb_spring.model.Product;
import com.skleb_spring.model.repository.ProductDaoDb;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTestSuite {
@Autowired
ProductServiceDb productServiceDb;
@Autowired
ProductDaoDb productDaoDb;

    @Test
    public void testGetProductByCategoryName(){
        Product product = new Product("Test", "TestTest", new BigDecimal(100));
        //productDaoDb.save(product);
        String categoryName =product.getCategory();
        List<Product> productList = productServiceDb.getProductListByCategoryName(categoryName);

        Assertions.assertTrue(productList.size()>0);


    }


}
