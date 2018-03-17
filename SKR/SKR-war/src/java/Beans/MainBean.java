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
import java.io.IOException;
import java.io.Serializable;

public class MainBean implements Serializable {

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
        String UserLogin = "AdminSKR";
        String UserPassword = "SKR";
        if (Login.compareTo(UserLogin) == 0 && Password.compareTo(UserPassword) == 0) {
            Authentication = "True";
            Name = "ProninAdmin";
            return "Manage.xhtml";
        } else {
            return HardCode();
        }
    }

    public String HardCode() {
        String UserLogin = "SKR";
        String UserPassword = "SKR";
        if (Login.compareTo(UserLogin) == 0 && Password.compareTo(UserPassword) == 0) {
            Authentication = "True";
            Name = "ProninUsers";
            return "UStorage.xhtml";
        } else {
            Authentication = "login or Password - invalid";
            return "404.xhtml";
        }
    }

}
