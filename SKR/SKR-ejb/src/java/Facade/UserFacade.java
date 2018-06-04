/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author INFERUS
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "SKR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    public User registered(String name) {
        List list = em.createNamedQuery("User.findByName").setParameter("name", name).getResultList();
        if (list.size() > 0) {
            return (User) list.get(0);
        }
        return null;
    }

    public Boolean registered(String name, String email) {
        List list = em.createNamedQuery("User.findByUserOrEmail").setParameter("name", name).setParameter("email", email).getResultList();
        if (list.size() > 0) {
            return true;
        }
        return false;
    }

    public String findUserRole(String name, String password) {
        String result = "";

        List list = em.createNamedQuery("User.findUserRole").setParameter("name", name).setParameter("password", password).getResultList();
        if (list.size() == 1) {
            User u = (User) list.get(0);
            String role = u.getRole().getRolename();

            if (role.equals("user")) {
                return "UStorage";
            }
            if (role.equals("admin")) {
                return "Manage";
            }

        }
        return result;
    }
    
        @Override
    public User findById(int id) {
        return em.find(User.class, id);
    }

}