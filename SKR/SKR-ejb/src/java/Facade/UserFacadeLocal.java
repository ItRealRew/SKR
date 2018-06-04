/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INFERUS
 */
@Local
public interface UserFacadeLocal {

    void create(User user);

    void edit(User user);

    void remove(User user);

    User find(Object id);

    Boolean registered(String name, String email);

    User registered(String name);

    String findUserRole(String name, String password);

    List<User> findAll();

    List<User> findRange(int[] range);

    int count();
    
    User findById(int id);

}
