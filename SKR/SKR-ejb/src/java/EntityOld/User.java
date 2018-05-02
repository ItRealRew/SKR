/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityOld;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class User implements Serializable {

    public int id;
    public String name;
    public String login;
    public String role;
    public String Password;

    public User(int id, String name, String login, String role, String Password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.role = role;
        this.Password = Password;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
