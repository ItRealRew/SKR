/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Unit;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author INFERUS
 */
@Stateless
public class UnitFacade extends AbstractFacade<Unit> implements UnitFacadeLocal {

    @PersistenceContext(unitName = "SKR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnitFacade() {
        super(Unit.class);
    }
    
}
