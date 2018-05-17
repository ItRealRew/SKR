/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entity.*;
import Facade.*;
import java.beans.*;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author INFERUS
 */
@Named(value = "loginBean")
@SessionScoped
@ManagedBean
public class LoginBean implements Serializable {

    @EJB
    UserFacadeLocal userFacadeLocal;

    User user;
    private String name = "11";
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginBean() {
        user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String create() {
        /* long i = drivingLicenseCategoryFacadeLocal.count()+1;
      licenseCategory.setId(i);
      drivingLicenseCategoryFacadeLocal.create(licenseCategory);*/

        return "categoryList";
    }

    public String InputSystem() {
        if (userFacadeLocal.findUserBool(name, password)) {
            return "UStorage";
        }
        else {return "Manage";}
    }
        /*    
        if (login.GetUserLogin(Login, Password) == null) {
            Authentication = "login or Password - invalid";
            return "404";
        } else {
            if (login.GetUserLogin(Login, Password) == "Admin") {
                Authentication = "True";
                Name = login.getName();
                return "Manage";
            } else {
                Authentication = "True";
                Name = login.getName();
                return "UStorage";
            }*/
    


    public Collection<User> getAll() {
        return userFacadeLocal.findAll();
    }

}
