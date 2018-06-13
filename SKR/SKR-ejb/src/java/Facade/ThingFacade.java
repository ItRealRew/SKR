/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.*;
import Entity.Thing;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author INFERUS
 */
@Stateless
public class ThingFacade extends AbstractFacade<Thing> implements ThingFacadeLocal {

    @PersistenceContext(unitName = "SKR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ThingFacade() {
        super(Thing.class);
    }
    
        public ArrayList<Thing> findByStorage(Stock stock) {
        List list = em.createNamedQuery("Thing.findByStorage").setParameter("Stock", stock).getResultList();

        ArrayList array = new ArrayList();

        for (int i = 0; i < list.size(); i++) {
            array.add(list.get(i));
        }
        return array;
    }

    public Boolean findByNameInStock(String name,Stock stock) {

        List list = em.createNamedQuery("Thing.findByNameInStock").setParameter("name", name).setParameter("Stock", stock).getResultList();
        if (list.size() > 0) {
            return true;
        }
        return false;

    }

    public Thing findByNameForObjec(String name) {

        return (Thing) em.createNamedQuery("Thing.findByName").setParameter("name", name).getResultList().get(0);

    }

    public List<Thing> findByPathAndStock(String name, Stock stock) {
        List<Thing> things = em.createNamedQuery("Thing.findByPathAndStock").setParameter("name", name).setParameter("Stock", stock).getResultList();
        List<Thing> t = new ArrayList<Thing>();
        
        for (int i=0;i<things.size();i++){
            if (!things.get(i).getStock().getBlocked())
            t.add(things.get(i));
        }


        return t;
    }
    
}
