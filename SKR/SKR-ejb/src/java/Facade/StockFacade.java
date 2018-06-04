/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Stock;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author INFERUS
 */
@Stateless
public class StockFacade extends AbstractFacade<Stock> implements StockFacadeLocal {

    @PersistenceContext(unitName = "SKR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StockFacade() {
        super(Stock.class);
    }

    public List<Stock> findUserStock() {

        List list = em.createNamedQuery("User.findByUser").getResultList();
        return list;

    }

    @Override
    public Stock findById(int id) {
        return em.find(Stock.class, id);
    }
    

    public Stock findlast() {
        Stock s = (Stock) em.createNamedQuery("Stock.findLast").getResultList().get(0);
        return s;
    }


}
