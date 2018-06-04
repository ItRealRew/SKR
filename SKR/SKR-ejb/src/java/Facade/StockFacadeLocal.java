/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Stock;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INFERUS
 */
@Local
public interface StockFacadeLocal {

    void create(Stock stock);

    void edit(Stock stock);

    void remove(Stock stock);

    Stock find(Object id);
    
    Stock findlast();

    List<Stock> findAll();
    
    List<Stock> findUserStock();

    List<Stock> findRange(int[] range);
    
    Stock findById(int id);

    int count();
    
}
