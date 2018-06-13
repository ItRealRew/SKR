/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Img;
import Entity.Pattern;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author INFERUS
 */
@Stateless
public class ImgFacade extends AbstractFacade<Img> implements ImgFacadeLocal {

    @PersistenceContext(unitName = "SKR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImgFacade() {
        super(Img.class);
    }

    public List<Img> findByPattern(Pattern pattern) {
        return em.createNamedQuery("Img.findByPattern").setParameter("idPatern", pattern).getResultList();
    }
    
        public Img findById(int id) {
        return em.find(Img.class, id);
    }

}
