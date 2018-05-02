/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeansOld;

import EntityOld.Storage;
import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author INFERUS
 */
@ManagedBean(name = "StorageDao")
public class StorageDao {
    
    public Storage s = new Storage(1,"S1",1,"type1");
    private ArrayList<Storage> storages = new ArrayList<Storage>();

    
    public ArrayList<Storage> getStorages() {
                
        storages.add(s);
        return storages;
    }

    
    public String addStor() {
        //storages.add(s);
        return "s";
    }

    
    public void delStor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void viewStor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public String select() {
        return "toUProduct";
    }
    
}