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
    ImgFacadeLocal imgFacadeLocal;
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
    private List<Thing> listThing;

    private String name;
    private Integer quantity;
    private Date dateupdate;
    private String nameimg;
    private Stock idStock;

    private Unit unit;
    private Integer unitId;

    private Img img;
    private Integer imgId;

    public Img getImg() {
        return img;
    }

    public void setImg(Img img) {
        this.img = img;
    }

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
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

    public List<Thing> getListThing() {
        return listThing;
    }

    public void setListThing(List<Thing> listThing) {
        this.listThing = listThing;
    }

    public List<Thing> viewThing(Stock stock) {
        listThing = thingFacadeLocal.findByStorage(stock);

        return listThing;

    }

    public List<String> viewThingString() {
        List<String> matches = new ArrayList<>();

        for (Thing s : listThing) {
            matches.add(s.getName());

        }
        return matches;
    }

    public Collection<Unit> selectUnit() {

        return unitFacadeLocal.findAll();
    }

    public Collection<Img> viewImg(Pattern pattern) {

        return imgFacadeLocal.findByPattern(pattern);
       
    }

    public String addThing(Stock stock) {

        if (thingFacadeLocal.findByNameInStock(name, stock)) {

            Unit un = unitFacadeLocal.find((Object) unitId);

            Thing thisThing = thingFacadeLocal.findByNameForObjec(name);
            thisThing.setQuantity(getQuantity());
            thisThing.setUnit(un);
            thisThing.setImg(imgFacadeLocal.findById(imgId));

            thingFacadeLocal.edit(thisThing);

        } else {
            Thing thisThing = new Thing();
            Unit un = unitFacadeLocal.find((Object) unitId);
            Date date = new Date();

            thisThing.setName(name);
            //thisThing.setNameimg("/img");
            thisThing.setQuantity(getQuantity());
            thisThing.setUnit(un);
            thisThing.setDateupdate(date);
            thisThing.setStock(stock);

            thisThing.setImg(imgFacadeLocal.findById(imgId));

            thingFacadeLocal.create(thisThing);

        }
        setAllNull();
        return "success";

    }

    public String delThing(Thing thisThing) {

        thingFacadeLocal.remove(thisThing);

        return "success";
    }

    public void setAllNull() {

        name = null;
        quantity = null;
        dateupdate = null;
        nameimg = null;
        idStock = null;

    }

}
