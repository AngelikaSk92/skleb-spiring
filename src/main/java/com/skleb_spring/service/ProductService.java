package com.skleb_spring.service;

import com.skleb_spring.model.Category;
import com.skleb_spring.model.Product;
import com.skleb_spring.model.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.transform.AbstractProcessTask;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;

    public List<Product> getAllProducts(){
      return productDAO.all();
    }

    public Product getProductByName(String name) {
        return productDAO.byName(name);
    }

    public Map<Category, List<Product>> getProductsByCategory(){

        Map<Category,List<Product>> categoryListMap = new HashMap<>();
        for(Product p : productDAO.all()){
            if(categoryListMap.containsKey(p.getCategory())){
                List<Product> listDoEdit=categoryListMap.get(p.getCategory());
                listDoEdit.add(p);
                categoryListMap.put(p.getCategory(),listDoEdit);
            }else {
                List<Product> newList=new ArrayList<>();
                newList.add(p);
                categoryListMap.put(p.getCategory(),newList);
            }
        }
        return categoryListMap;
    }

    public List<Category> getCategoryUniqueName(){
        List<Category> uniqueCategoryName=new ArrayList<>();
        Map<Category, List<Product>> listOfCategory = getProductsByCategory();
        for (Map.Entry<Category, List<Product>> categoryListMap : listOfCategory.entrySet()) {
            uniqueCategoryName.add(categoryListMap.getKey());
        }
        return uniqueCategoryName;
    }

    public List<String> getCategoryUniqueStringName(){
        List<String> uniqueCategoryName=new ArrayList<>();
        Map<Category, List<Product>> listOfCategory = getProductsByCategory();
        for (Map.Entry<Category, List<Product>> categoryListMap : listOfCategory.entrySet()) {
            uniqueCategoryName.add(categoryListMap.getKey().name());
        }
        return uniqueCategoryName;
    }

    public String getCategoryByCategoryName(String categoryName){
        List<String> uniqueCategoryName=getCategoryUniqueStringName();
        for(String s: uniqueCategoryName){
            if(s.equals(categoryName)){
                return s;
            }
        }
        return null;
    }

    public List<Product> getProductListByCategoryName(String categoryName){
        Map<Category,List<Product>> categoryListMap = getProductsByCategory();
        List<Product> listOfProductsByCategory=new ArrayList<>();
        for (Map.Entry<Category, List<Product>> clm : categoryListMap.entrySet()) {
            if(categoryName.equals(clm.getKey().name())){
                listOfProductsByCategory=clm.getValue();
            }
        }
        return listOfProductsByCategory;
    }


    public void saveNewProduct(Product product) {


    }

    public void createProductFromStrings(String name, String description, double price, String category){
        productDAO.createProductStringValues(name,description,price,category);
    }
}
