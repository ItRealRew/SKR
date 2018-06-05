/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Stock;
import Entity.StockUser;
import Entity.User;
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
public class StockUserFacade extends AbstractFacade<StockUser> implements StockUserFacadeLocal {

    @PersistenceContext(unitName = "SKR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StockUserFacade() {
        super(StockUser.class);
    }

    public ArrayList<Stock> findStockUser(User User) {

        List<StockUser> l = em.createNamedQuery("StockUser.findUserStock").setParameter("idUser", User).getResultList();

         ArrayList list = new ArrayList();

        for (int i=0; i<l.size() ;i++){
            list.add(l.get(i).getIdStock());
        }
        

        return list;

    }
    


}
