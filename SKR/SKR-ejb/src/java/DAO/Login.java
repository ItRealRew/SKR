/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import EntityOld.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author user
 */
@Stateful
public class Login implements LoginLocal {
    
    public String name;
    public String role;
    public int id;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User Admin = new User(1, "AdminPronin", "AdminSKR", "Admin", "SKR");
    public User User1 = new User(2, "UserPronin", "SKR", "User", "SKR");
    
    @Override
    public String GetUserLogin(String Login, String Password) {
        if (Login.compareTo(Admin.login) == 0 && Password.compareTo(Admin.Password) == 0) 
        {
            name = Admin.name;
            role = Admin.role;
            id = Admin.id;
            return  role;
        }
        if (Login.compareTo(User1.login) == 0 && Password.compareTo(User1.Password) == 0) 
        {
            name = User1.name;
            role = User1.role;
            id = User1.id;
            return  role;
        }
        return null;
    }
}
