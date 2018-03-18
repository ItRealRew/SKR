/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.User;
import javax.ejb.Local;

/**
 *
 * @author user
 */
@Local
public interface LoginLocal {

    public User GetUserLogin(String login, String Password);
}
