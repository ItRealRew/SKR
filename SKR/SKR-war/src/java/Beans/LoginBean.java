/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entity.*;
import Facade.*;
import Validators.EmailValidator;
import java.beans.*;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

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
    RoleFacadeLocal roleFacadeLocal;

    private User user;
    private String name;
    private String password;
    private String email;
    private String error;

    // @Size(min = 3, max = 10, message = "Min 3 and max 10 characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //@Size(min = 3, max = 10, message = "Min 3 and max 10 characters")
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
@Pattern(regexp = "[0-9]+$")
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

        if (userFacadeLocal.findUserRole(name, password) != null) {
            setUser(userFacadeLocal.registered(name));
            String goTo = userFacadeLocal.findUserRole(name, password);
            return goTo;

        } else {
            setError("Пользователя с такими параметрами не существует");
            return "404";
        }
    }

    public String toRegister() {

        EmailValidator emailValidator = new EmailValidator();

        if (!(name == null || password == null || email == null)) {
            if (emailValidator.validate(email)) {
                if (!userFacadeLocal.registered(name, email)) {
                    user.setName(name);
                    user.setPassword(password);
                    user.setEmail(email);
                    user.setRole(roleFacadeLocal.defaultRole());

                    userFacadeLocal.create(user);

                    return InputSystem();
                } else {
                    setError("Такой логин/email уже зарегистрирован");
                    return "404";
                }
            } else {
                setError("Провертьте правильность поля Email");
                return "404";
            }
        } else {
            setError("Заполните все поля");
            return "404";
        }
    }

    public String logout() {

        user = null;
        name = null;
        password = null;
        email = null;
        error = null;

        return "logout";
    }

}
