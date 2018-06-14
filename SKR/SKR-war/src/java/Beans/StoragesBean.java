/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entity.*;
import Facade.*;
import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author INFERUS
 */
@Named(value = "storagesBean")
@SessionScoped
@ManagedBean
public class StoragesBean implements Serializable {

    @EJB
    PatternFacadeLocal patternFacadeLocal;
    @EJB
    StockFacadeLocal stockFacadeLocal;
    @EJB
    StockUserFacadeLocal stockUserFacadeLocal;
    @EJB
    UserFacadeLocal userFacadeLocal;
        @EJB
        ThingFacadeLocal thingFacadeLocal;

    private Stock stock;

    private String name;

    private Pattern pattern;
    private Integer patternId;

    public Integer getPatternId() {
        return patternId;
    }

    public void setPatternId(Integer patternId) {
        this.patternId = patternId;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public ArrayList<Stock> viewStorages(User user) {

        ArrayList<Stock> stocks = stockUserFacadeLocal.findStockUser(user);

        return stocks;

    }
    
        public boolean m(String bool) {

            System.out.println(bool+" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            
        return true;

    }

    public String delStorage(Stock idStorage) {

        stockUserFacadeLocal.remove(stockUserFacadeLocal.findStock(idStorage));
        
        ArrayList<Thing> things = thingFacadeLocal.findByStorage(idStorage);
        
        for(Thing thing:things){
        thingFacadeLocal.remove(thing);
        }
        
        Stock stock = stockFacadeLocal.findById(idStorage.getId());
        stockFacadeLocal.remove(stock);

        return "success";

    }

    public String addStorage(int idUser) {


        Stock thisStock = new Stock();
        User user = new User();
        StockUser stockUser = new StockUser();

        thisStock.setName(name);
        pattern = patternFacadeLocal.findById(patternId);
        thisStock.setPattern(pattern);

        thisStock.setBlocked(false);
        stockFacadeLocal.create(thisStock);


        //косяк findlast
        //thisStock = stockFacadeLocal.findlast();
        user = userFacadeLocal.findById(idUser);
        stockUser.setIdStock(thisStock);
        stockUser.setIdUser(user);

        stockUserFacadeLocal.create(stockUser);

        return "success";

    }

    public String selectStorage(int idStorage) {
        stock = stockFacadeLocal.findById(idStorage);

        return "toUProduct";

    }

    public String selectEditStorage(int idStorage) {
        stock = stockFacadeLocal.findById(idStorage);

        return "edit";
    }

    public String editStorage() {

        stock.setName(name);
        stockFacadeLocal.edit(stock);
        return "success";

    }

    public Collection<Pattern> viewPattern() {

        return patternFacadeLocal.findAll();
    }

}
