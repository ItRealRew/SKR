/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Stock;
import Entity.Thing;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INFERUS
 */
@Local
public interface ThingFacadeLocal {

    void create(Thing thing);

    void edit(Thing thing);

    void remove(Thing thing);

    Thing find(Object id);

    List<Thing> findAll();

    List<Thing> findRange(int[] range);
    
    ArrayList<Thing> findByStorage (Stock stock);

    int count();
    
}
