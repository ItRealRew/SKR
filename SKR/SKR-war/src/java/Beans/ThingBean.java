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
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author INFERUS
 */
@Named(value = "thingBean")
@SessionScoped
@ManagedBean
public class ThingBean implements Serializable {

    @EJB
    StockFacadeLocal stockFacadeLocal;
    @EJB
    StockUserFacadeLocal stockUserFacadeLocal;
    @EJB
    UserFacadeLocal userFacadeLocal;
    @EJB
    ThingFacadeLocal thingFacadeLocal;
    @EJB
    UnitFacadeLocal unitFacadeLocal;

    private Thing thing;

    private String name;
    private int quantity;
    private Date dateupdate;
    private String nameimg;
    private Stock idStock;

    private Unit unit;
    private Integer unitId;

    public Thing getThing() {
        return thing;
    }

    public void setThing(Thing thing) {
        this.thing = thing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDateupdate() {
        return dateupdate;
    }

    public void setDateupdate(Date dateupdate) {
        this.dateupdate = dateupdate;
    }

    public String getNameimg() {
        return nameimg;
    }

    public void setNameimg(String nameimg) {
        this.nameimg = nameimg;
    }

    public Stock getIdStock() {
        return idStock;
    }

    public void setIdStock(Stock idStock) {
        this.idStock = idStock;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public ArrayList<Thing> viewThing(Stock stock) {
        ArrayList<Thing> thing = thingFacadeLocal.findByStorage(stock);

        return thing;

    }

    public Collection<Unit> selectUnit() {

        return unitFacadeLocal.findAll();
    }

    public String addThing(Stock stock) {

        Thing thisThing = new Thing();
        Unit un = new Unit();
        Date date = new Date();
        un = unitFacadeLocal.find((Object) unitId);

        thisThing.setName(name);
        thisThing.setNameimg("/img");
        thisThing.setQuantity(quantity);
        thisThing.setUnit(un);
        thisThing.setDateupdate(date);
        thisThing.setIdStock(stock);

        thingFacadeLocal.create(thisThing);

        return "success";

    }
    
        public String delThing(Thing thisThing) {
            
            thingFacadeLocal.remove(thisThing);

        return "success";
    }

}
