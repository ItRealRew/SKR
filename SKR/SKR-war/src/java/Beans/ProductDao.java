/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Product;
import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author INFERUS
 */
@ManagedBean(name = "ProductDao")
public class ProductDao {
    
    
    private ArrayList<Product> products = new ArrayList<Product>();
    private int i = 1;
    
    
    public ArrayList<Product> getProducts() {
        return products;
    }

    
    public String addProd() {
        Product p = new Product(i,"P1",10,"type1");
        products.add(p);
        return "success";
    }

    
    public String delProd() {
        products.remove(products.size());
        return "success";
    }

    
    public void viewProd() {
        
    }
    
}