/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entity.*;
import Facade.*;
import Model.*;
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
@Named(value = "searchBean")
@SessionScoped
@ManagedBean
public class SearchBean implements Serializable {

    @EJB
    StockFacadeLocal stockFacadeLocal;
    @EJB
    StockUserFacadeLocal stockUserFacadeLocal;
    @EJB
    UserFacadeLocal userFacadeLocal;
    @EJB
    ThingFacadeLocal thingFacadeLocal;

    private String searchSrt;

    public String getSearchSrt() {
        return searchSrt;
    }

    public void setSearchSrt(String searchSrt) {
        this.searchSrt = searchSrt;
    }

    public String goSearch() {

        return "goSearch";
    }

    public ArrayList<ResSearch> searchBysearchSrt(User user) {

        ArrayList<ResSearch> resultList = new ArrayList<ResSearch>();

        ResSearch result;

        ArrayList<Stock> stockUsers = stockUserFacadeLocal.findStockUser(user);
        
                    List<Thing> listThing = new  ArrayList<Thing>();

        for (int j = 0; j < stockUsers.size(); j++) {
            System.out.println(stockUsers.get(j).getName()+" m!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 List<Thing> list = thingFacadeLocal.findByPathAndStock(searchSrt, stockUsers.get(j));
 listThing.addAll(list);
            
        }

        for (int i = 0; i < listThing.size(); i++) {
            result = new ResSearch();
            result.setId((Integer) i + 1);
            result.setStock(listThing.get(i).getIdStock());
            result.setThing(listThing.get(i));
            resultList.add(result);

        }

        return resultList;
    

}
}