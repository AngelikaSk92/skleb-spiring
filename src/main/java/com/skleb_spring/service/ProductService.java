package com.skleb_spring.service;

import com.skleb_spring.model.Category;
import com.skleb_spring.model.Product;
import com.skleb_spring.model.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, List<Product>> getProductsByCategory(){

        Map<String,List<Product>> categoryListMap = new HashMap<>();
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

    public List<String> getCategoryUniqueName(){
        List<String> uniqueCategoryName=new ArrayList<>();
        Map<String, List<Product>> listOfCategory = getProductsByCategory();
        for (Map.Entry<String, List<Product>> categoryListMap : listOfCategory.entrySet()) {
            uniqueCategoryName.add(categoryListMap.getKey());
        }
        return uniqueCategoryName;
    }

    public List<String> getCategoryUniqueStringName(){
        List<String> uniqueCategoryName=new ArrayList<>();
        Map<String, List<Product>> listOfCategory = getProductsByCategory();
        for (Map.Entry<String, List<Product>> categoryListMap : listOfCategory.entrySet()) {
            uniqueCategoryName.add(categoryListMap.getKey());
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
        Map<String,List<Product>> categoryListMap = getProductsByCategory();
        List<Product> listOfProductsByCategory=new ArrayList<>();
        for (Map.Entry<String, List<Product>> clm : categoryListMap.entrySet()) {
            if(categoryName.equals(clm.getKey())){
                listOfProductsByCategory=clm.getValue();
            }
        }
        return listOfProductsByCategory;
    }


    public void saveNewProduct(Product product) {
        productDAO.addProduct(product);

    }

    public void createProductFromStrings(String name, String description, double price, String category){
        productDAO.createProductStringValues(name,description,price,category);
    }

    public Product findProductByName(String name){
        for(Product p: productDAO.all()){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    public void deleteProduct(String name) {
        Product product = findProductByName(name);
        productDAO.all().remove(product);
    }

    public void updateProduct(Product newProduct) {
        productDAO.all().add(newProduct);
    }
}
