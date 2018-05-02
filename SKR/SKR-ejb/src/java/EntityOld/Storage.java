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
public class Storage implements Serializable {

    public int id;
    public String name;
    public int idUser;
    public String type;
    
        public Storage(int id, String name, int idUser, String type) {
        this.id = id;
        this.name = name;
        this.idUser = idUser;
        this.type = type;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
