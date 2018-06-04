/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Stock;
import Entity.StockUser;
import Entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INFERUS
 */
@Local
public interface StockUserFacadeLocal {

    void create(StockUser stockUser);

    void edit(StockUser stockUser);

    void remove(StockUser stockUser);

    StockUser find(Object id);

    List<StockUser> findAll();
    
    ArrayList<Stock> findStockUser(User User);

    List<StockUser> findRange(int[] range);

    int count();
    
}
