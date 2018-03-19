/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author user
 */
import Entity.User;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;

public class MainBean implements Serializable {

    @EJB
    private DAO.LoginLocal login;

    private String Login;
    private String Password;
    private String Authentication;
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAuthentication() {
        return Authentication;
    }

    public void setAuthentication(String Authentication) {
        this.Authentication = Authentication;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String InputSystem() {
        if (login.GetUserLogin(Login, Password) == null) {
            Authentication = "login or Password - invalid";
            return "404.xhtml";
        } else {
            if (login.GetUserLogin(Login, Password) == "Admin") {
                Authentication = "True";
                Name = login.getName();
                return "Manage.xhtml";
            } else {
                Authentication = "True";
                Name = login.getName();
                return "UStorage.xhtml";
            }
        }
    }

}
