/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Stock;
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
    
        public ArrayList<Thing> findByStorage (Stock stock) {
        List list = em.createNamedQuery("Thing.findByStorage").setParameter("idStock", stock).getResultList();
        
         ArrayList array = new ArrayList();

        for (int i=0; i<list.size() ;i++){
            array.add(list.get(i));
        }
        return array;
    }
    
}
