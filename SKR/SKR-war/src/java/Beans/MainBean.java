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

    public void InputSystem() {
        String UserLogin = "SKR";
        String UserPassword = "SKR";
        if (Login.compareTo(UserLogin) == 0) {
            if (Password.compareTo(UserPassword) == 0) {
                Authentication = "True";
            } else {
                Authentication = "login or Password - invalid";
            }
        } else {
            Authentication = "login or Password - invalid";
        }
    }
}
