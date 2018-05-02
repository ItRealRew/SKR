/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeansOld;

import EntityOld.Product;
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
        Product p = new Product(1,"P1",10,"type1");
        products.add(p);
        Product p2 = new Product(2,"dsfs",10000,"type2");
        products.add(p2);
        return "success";
    }

    
    public String delProd() {
        products.remove(products.size());
        return "success";
    }

    
    public void viewProd() {
        
    }
    
}