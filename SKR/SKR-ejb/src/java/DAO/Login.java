/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author user
 */
@Stateful
public class Login implements LoginLocal {

    public User Admin = new User(1, "AdminPronin", "AdminSKR", "Admin", "SKR");
    public User User1 = new User(2, "UserPronin", "SKR", "User", "SKR");

    @Override
    public User GetUserLogin(String Login, String Password) {

        return null;
    }
}
