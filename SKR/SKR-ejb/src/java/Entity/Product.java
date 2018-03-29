/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Product implements Serializable {
    public int id;
    public String NameProduct;
    public int lot;
    public String Typelot;
    
        public Product(int id, String NameProduct, int lot, String Typelot) {
        this.id = id;
        this.NameProduct = NameProduct;
        this.lot = lot;
        this.Typelot = Typelot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return NameProduct;
    }

    public void setNameProduct(String NameProduct) {
        this.NameProduct = NameProduct;
    }

    public int getLot() {
        return lot;
    }

    public void setLot(int lot) {
        this.lot = lot;
    }

    public String getTypelot() {
        return Typelot;
    }

    public void setTypelot(String Typelot) {
        this.Typelot = Typelot;
    }

}
