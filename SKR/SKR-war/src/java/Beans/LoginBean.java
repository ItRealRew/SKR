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
    @EJB
    RoleFacadeLocal role;


    private User user;
    private String name;
    private String password;
    private String email;
    private String error;

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
    
        public Collection<User> getAll() {
        return userFacadeLocal.findAll();
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getError() {
        return error;
    }


    public void setError(String error) {
        this.error = error;
    }

    public String InputSystem() {

        setUser(userFacadeLocal.registered(name));
        if (getUser() != null) {
            String goTo = userFacadeLocal.findUserRole(name, password);
            return goTo;

        } else {
            setError("Пользователя с такими параметрами не существует");
            return "404";
        }

    }

    public String toRegister() {

        if (!userFacadeLocal.registered(name, email)) {

            user.setName(name);
            user.setPassword(password);
            user.setEmail(email);
            user.setRole(role.defaultRole());

            userFacadeLocal.create(user);

            return InputSystem();
        } else {
            setError("Такой логин/email уже зарегистрирован");
            return "404";
        }
    }

}
