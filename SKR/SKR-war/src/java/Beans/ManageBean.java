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
@Named(value = "manageBean")
@SessionScoped
@ManagedBean
public class ManageBean implements Serializable {

    @EJB
    UserFacadeLocal userFacadeLocal;
    @EJB
    RoleFacadeLocal role;
    @EJB
    StockFacadeLocal stockFacadeLocal;
    @EJB
    StockUserFacadeLocal stockUserFacadeLocal;
    @EJB
    ThingFacadeLocal thingFacadeLocal;
    @EJB
    UnitFacadeLocal unitFacadeLocal;

    private Stock stock;
    private String searchStr = "";
    

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public String getSearchStr() {
        return searchStr;
    }

    public void setSearchStr(String searchStr) {
        this.searchStr = searchStr;
    }

    public List<Stock> viewStorages() {
        List<Stock> stocks;

        if ((searchStr.equals(""))) {

            stocks = stockFacadeLocal.findAll();
       } else {
            stocks = stockFacadeLocal.search(getSearchStr());
        }

        return stocks;

    }

    public String reloadPage() {

        return "reloadPage";

    }
        public String blockStorages(int id) {

        Stock stock = stockFacadeLocal.findById(id);

        stock.setBlocked(!stock.getBlocked());
        stockFacadeLocal.edit(stock);

        return "success";

    }

}
