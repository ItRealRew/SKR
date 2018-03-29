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
 *
 * @author user
 */
@Local
public interface LoginLocal {

    public String getRole();

    public int getId();

    public String getName();

    public String GetUserLogin(String login, String Password);
}
